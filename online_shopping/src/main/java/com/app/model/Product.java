package com.app.model;

public class Product {
	
	private int productId;
	private String productName;
	private double price;
	private double ratings;
	//private double quantity;
	
//	public double getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(double quantity) {
//		this.quantity = quantity;
//	}
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, String productName, double price, double ratings) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.ratings = ratings;
	}
	
	public Product(String productName, double price, double ratings) {
		super();
		this.productName = productName;
		this.price = price;
		this.ratings = ratings;
	}
	
	
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", ratings="
				+ ratings + "]";
	}
	
	
	
	
	
	

}
