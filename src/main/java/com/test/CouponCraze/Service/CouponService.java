package com.test.CouponCraze.Service;

import com.test.CouponCraze.Exception.CouponNotFoundException;
import com.test.CouponCraze.model.Coupon;
import com.test.CouponCraze.model.Product;
import com.test.CouponCraze.repository.CouponRepository;
import com.test.CouponCraze.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Coupon> getAllCoupons() {

        return couponRepository.findAll();
    }

    public Coupon addCoupon(Coupon coupon) {

        return couponRepository.save(coupon);
    }

    public void deleteCoupon(Long id) {

        couponRepository.deleteById(id);
    }

    public Coupon applyCoupon(String code) throws CouponNotFoundException {
        Coupon coupon = couponRepository.findByCode(code);
        if (coupon == null || coupon.isUsed()) {
            throw new CouponNotFoundException("Coupon not found or already used");
        }
        coupon.setUsed(true);
        return couponRepository.save(coupon);
    }

    public double calculateDiscountedPrice(String code, List<Long> productIds) throws CouponNotFoundException{
        Coupon coupon = couponRepository.findByCodeAndIsUsedFalse(code);
        if (coupon == null) {
            throw new CouponNotFoundException("Coupon not found or already used");
        }

        List<Product> products = productRepository.findAllById(productIds);
        double totalPrice = products.stream().mapToDouble(Product::getPrice).sum();
        double discountedPrice = totalPrice - (totalPrice * coupon.getDiscount() / 100);


        coupon.setUsed(true);
        couponRepository.save(coupon);

        return discountedPrice;
    }
}
