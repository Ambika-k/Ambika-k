package com.zensar.ide.dto;

import javax.persistence.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CouponDto {
	private int couponId;
	private String couponCode;
	private String expDate;
	private int couponPrice;
	private String couponDesc;
	private int discount;
	

}
