package com.app.model;

public class Cart {
	
	
	private int customerId;
	private int productId;
	private int quantity;
	private Product product;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int customerId, int productId, int quantity) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
	}
//	@Override
//	public String toString() {
//		return "Cart [cartId=" + cartId + ", customerId=" + customerId + ", productId=" + productId + ", quantity="
//				+ quantity + "]";
//	}
	@Override
	public String toString() {
		return "Cart [customerId=" + customerId +  ", " + product + ", quantity="+ quantity +"]";
	}
	
	
	

}
