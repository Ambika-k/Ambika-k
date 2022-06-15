package com.zensar.ide.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.ide.entity.Coupon;
import com.zensar.ide.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {
	@Autowired
	private CouponRepository couponRepository;

	public CouponServiceImpl() {
	}

	@Override
	public Coupon getCoupon(int couponId) {
		return couponRepository.findById(couponId).get();
	}

	@Override
	public List<Coupon> getCoupons() {
		return couponRepository.findAll();
	}

	@Override
	public void insertCoupon(Coupon coupon) {
		couponRepository.save(coupon);

	}

	@Override
	public void updateCoupon(int couponId, Coupon coupon) {
		couponRepository.save(coupon);

	}

	@Override
	public void deleteCoupon(int couponId) {
		couponRepository.deleteById(couponId);

	}

}
