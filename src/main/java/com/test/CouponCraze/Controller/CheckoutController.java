package com.test.CouponCraze.Controller;

import com.test.CouponCraze.Exception.CouponNotFoundException;
import com.test.CouponCraze.Service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/apply-coupon/{code}")
    public double applyCoupon(@PathVariable String code, @RequestBody List<Long> productIds) throws CouponNotFoundException {
        return couponService.calculateDiscountedPrice(code, productIds);
    }
}