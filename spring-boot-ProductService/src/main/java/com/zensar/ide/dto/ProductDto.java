package com.zensar.ide.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	private int productId;
	private String productName;
	private int productPrice;
	private int productQuantity;
	
	@Transient
	private String couponCode;
	
	
	
}
