package com.zensar.ide.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
//@NamedQueries(value = { @NamedQuery(name = "Product.byName", query = "from Product p where p.productName =?1"),
//		@NamedQuery(name = "Product.byNameOrPrice", query = "from Product p where p.productName=?1 or p.productPrice=?2") })

//@NamedNativeQueries(value = {
//		@NamedNativeQuery(name = "Product.byName", query = "select * from product p where p.product_name=?1",resultClass = Product.class),
//		@NamedNativeQuery(name = "Product.byNameOrPrice", query = "select * from product p where p.product_name=?1 or p.product_price=?2",resultClass = Product.class) })

public class Product {
	@Id
	private int productId;
	private String productName;
	private int productPrice;
	private int productQuantity;

	public Product() {
		super();
	}

	public Product(int productId, String productName, int productPrice, int productQuantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + "]";
	}

}
