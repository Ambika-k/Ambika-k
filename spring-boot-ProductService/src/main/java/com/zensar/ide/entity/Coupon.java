package com.zensar.ide.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.zensar.ide.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@NamedQueries(value = {  @NamedQuery(name = "Coupon.test", query = "from Coupon c where c.couponCode=?1"),
//@NamedQuery(name = "Coupon.test1", query = "from Coupon c where c.couponCode=?1 And c.expDate=?2")})

//@NamedNativeQueries(value = { @NamedNativeQuery(name = "Coupon.test", query = "select * from coupon c where c.coupon_code=?1",resultClass = Coupon.class),
//@NamedNativeQuery(name = "Coupon.test1", query = "select * from coupon c where c.coupon_code=?1 and c.exp_date=?2",resultClass = Coupon.class)})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {
	@Id
	private int couponId;
	private String couponCode;
	private String expDate;
	private int couponPrice;
	private String couponDesc;
	private int discount;

	
}
