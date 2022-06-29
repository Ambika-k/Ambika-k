package com.zensar.ide.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Transient;

import com.zensar.ide.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@NamedQueries(value = { @NamedQuery(name = "Product.byName", query = "from Product p where p.productName =?1"),
//		@NamedQuery(name = "Product.byNameOrPrice", query = "from Product p where p.productName=?1 or p.productPrice=?2") })

//@NamedNativeQueries(value = {
//		@NamedNativeQuery(name = "Product.byName", query = "select * from product p where p.product_name=?1",resultClass = Product.class),
//		@NamedNativeQuery(name = "Product.byNameOrPrice", query = "select * from product p where p.product_name=?1 or p.product_price=?2",resultClass = Product.class) })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	private int productId;
	private String productName;
	private int productPrice;
	private int productQuantity;

	@Transient
	private String couponCode;
	
}
