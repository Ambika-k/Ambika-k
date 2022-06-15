package com.zensar.ide.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.ide.dto.CouponDto;
import com.zensar.ide.entity.Coupon;
import com.zensar.ide.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {
	@Autowired
	private CouponRepository couponRepository;

	@Autowired
	private ModelMapper modelMapper;

	public CouponServiceImpl() {
	}

	@Override
	public CouponDto getCoupon(int couponId) {
		Coupon getCoupon = couponRepository.findById(couponId).get();
		return modelMapper.map(getCoupon,CouponDto.class);
		// return mapToDto(getCoupon);
	}

	@Override
	public List<CouponDto> getCoupons() {
		List<Coupon> listOfCoupons = couponRepository.findAll();
		List<CouponDto> listOfCouponDto = new ArrayList<CouponDto>();
		for (Coupon coupon : listOfCoupons) {
			//listOfCouponDto.add(mapToDto(coupon));
			listOfCouponDto.add(modelMapper.map(coupon,CouponDto.class));
		}
		return listOfCouponDto;
	}

	@Override
	public CouponDto insertCoupon(CouponDto couponDto) {
		/*
		 * Coupon coupon = new Coupon(); coupon.setCouponId(couponDto.getCouponId());
		 * coupon.setCouponCode(couponDto.getCouponCode());
		 * coupon.setExpDate(couponDto.getExpDate());
		 * coupon.setCouponPrice(couponDto.getCouponPrice());
		 * coupon.setCouponDesc(couponDto.getCouponDesc());
		 */
		//Coupon coupon = mapToEntity(couponDto);
		Coupon coupon = modelMapper.map(couponDto,Coupon.class);
		Coupon insertedCoupon = couponRepository.save(coupon);
		//return mapToDto(insertedCoupon);
		return modelMapper.map(insertedCoupon,CouponDto.class);

	}

	@Override
	public void updateCoupon(int couponId, CouponDto couponDto) {
		/*
		 * Coupon coupon = new Coupon(); coupon.setCouponId(couponDto.getCouponId());
		 * coupon.setCouponCode(couponDto.getCouponCode());
		 * coupon.setExpDate(couponDto.getExpDate());
		 * coupon.setCouponPrice(couponDto.getCouponPrice());
		 * coupon.setCouponDesc(couponDto.getCouponDesc());
		 */
		//Coupon coupon = mapToEntity(couponDto);
		Coupon coupon = modelMapper.map(couponDto,Coupon.class);
		couponRepository.save(coupon);

	}

	@Override
	public void deleteCoupon(int couponId) {
		couponRepository.deleteById(couponId);

	}

	/*
	 * public Coupon mapToEntity(CouponDto couponDto) { Coupon coupon = new
	 * Coupon(); coupon.setCouponId(couponDto.getCouponId());
	 * coupon.setCouponCode(couponDto.getCouponCode());
	 * coupon.setExpDate(couponDto.getExpDate());
	 * coupon.setCouponPrice(couponDto.getCouponPrice());
	 * coupon.setCouponDesc(couponDto.getCouponDesc()); return coupon; }
	 */
	/*
	 * public CouponDto mapToDto(Coupon coupon) { CouponDto couponDto = new
	 * CouponDto(); couponDto.setCouponId(coupon.getCouponId());
	 * couponDto.setCouponCode(coupon.getCouponCode());
	 * couponDto.setExpDate(coupon.getExpDate());
	 * couponDto.setCouponPrice(coupon.getCouponPrice());
	 * couponDto.setCouponDesc(coupon.getCouponDesc()); return couponDto; }
	 */

}
