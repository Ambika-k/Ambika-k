package com.zensar.ide.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
//@NamedQueries(value = {  @NamedQuery(name = "Coupon.test", query = "from Coupon c where c.couponCode=?1"),
//@NamedQuery(name = "Coupon.test1", query = "from Coupon c where c.couponCode=?1 And c.expDate=?2")})

//@NamedNativeQueries(value = { @NamedNativeQuery(name = "Coupon.test", query = "select * from coupon c where c.coupon_code=?1",resultClass = Coupon.class),
//@NamedNativeQuery(name = "Coupon.test1", query = "select * from coupon c where c.coupon_code=?1 and c.exp_date=?2",resultClass = Coupon.class)})


public class Coupon {
	@Id
	private int couponId;
	private String couponCode;
	private String expDate;
	private int couponPrice;
	private String couponDesc;

	public Coupon() {
		super();
	}

	public Coupon(int couponId, String couponCode, String expDate, int couponPrice, String couponDesc) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.expDate = expDate;
		this.couponPrice = couponPrice;
		this.couponDesc = couponDesc;
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public int getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(int couponPrice) {
		this.couponPrice = couponPrice;
	}

	public String getCouponDesc() {
		return couponDesc;
	}

	public void setCouponDesc(String couponDesc) {
		this.couponDesc = couponDesc;
	}

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponCode=" + couponCode + ", expDate=" + expDate + ", couponPrice="
				+ couponPrice + ", couponDesc=" + couponDesc + "]";
	}

}
