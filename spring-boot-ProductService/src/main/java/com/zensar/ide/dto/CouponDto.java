package com.zensar.ide.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponDto {
	private int couponId;
	private String couponCode;
	private String expDate;
	private int couponPrice;
	private String couponDesc;
	private int discount;
	

}
