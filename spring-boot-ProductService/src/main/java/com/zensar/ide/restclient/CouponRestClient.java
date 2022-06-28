package com.zensar.ide.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.zensar.ide.dto.CouponDto;

@FeignClient("COUPON-SERVICE-APP")
public interface CouponRestClient {

	@GetMapping("coupons/code/{couponCode}")
	CouponDto getCoupon(String couponCode);
}
