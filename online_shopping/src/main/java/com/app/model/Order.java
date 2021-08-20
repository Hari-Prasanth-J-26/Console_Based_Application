package com.app.model;

public class Order {
	
	private int orderId;
	private int customerId;
	private int productId;
	private String productName;
	private double ratings;
	private double cost;
	private String orderStatus;
	
	public Order(int orderId, int customerId, int productId, String productName, double ratings, double cost,
			String orderStatus) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.productId = productId;
		this.productName = productName;
		this.ratings = ratings;
		this.cost = cost;
		this.orderStatus = orderStatus;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Order(int orderId, int customerId, int productId, double cost, String orderStatus) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.productId = productId;
		this.cost = cost;
		this.orderStatus = orderStatus;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", productId=" + productId
				+ ", productName=" + productName + ", ratings=" + ratings + ", cost=" + cost + ", orderStatus="
				+ orderStatus + "]";
	}
	
	
	
	
	
	
}
