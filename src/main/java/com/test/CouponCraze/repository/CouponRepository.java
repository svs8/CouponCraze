package com.test.CouponCraze.repository;

import com.test.CouponCraze.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Coupon findByCode(String code);

    Coupon findByCodeAndIsUsedFalse(String code);
}