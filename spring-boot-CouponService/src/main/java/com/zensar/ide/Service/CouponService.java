package com.zensar.ide.Service;

import java.util.List;

import com.zensar.ide.dto.CouponDto;
import com.zensar.ide.entity.Coupon;

public interface CouponService {
	public CouponDto getCoupon(int CouponId);

	//public List<CouponDto> getCoupons();
	public List<CouponDto> getCoupons(int pageNumber,int pageSize);

	public CouponDto insertCoupon(CouponDto couponDto);

	public void updateCoupon(int CouponId, CouponDto couponDto);

	public void deleteCoupon(int CouponId);

	public List<CouponDto> getByCouponCode(String couponCode);

	public List<CouponDto> getByCouponCodeOrCouponPrice(String couponCode, int price);

	public List<CouponDto> getByCouponCodeAndExpDate(String couponCode, String expDate);

	public List<CouponDto> getByCouponCodeOrderByCouponPrice(String couponCode);

}
