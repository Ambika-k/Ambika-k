package com.zensar.ide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.ide.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

}
