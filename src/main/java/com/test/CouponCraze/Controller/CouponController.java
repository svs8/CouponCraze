package com.test.CouponCraze.Controller;

import com.test.CouponCraze.Service.CouponService;
import com.test.CouponCraze.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @GetMapping("/getAllCoupons")
    public List<Coupon> getAllCoupons() {
        return couponService.getAllCoupons();
    }

    @PostMapping("/addCoupon")
    public Coupon addCoupon(@RequestBody Coupon coupon) {
        return couponService.addCoupon(coupon);
    }

    @DeleteMapping("deleteCoupon/{id}")
    public void deleteCoupon(@PathVariable Long id) {
        couponService.deleteCoupon(id);
    }

    @PostMapping("/apply/{code}")
    public Coupon applyCoupon(@PathVariable String code) throws Exception {
        return couponService.applyCoupon(code);
    }
}
