package com.app.model;

public class Status {
	
	private int orderId;
	private int customerId;
	private String orderShipped;
	private String orderReceived;
	
	
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
	public String getOrderShipped() {
		return orderShipped;
	}
	public void setOrderShipped(String orderShipped) {
		this.orderShipped = orderShipped;
	}
	public String getOrderReceived() {
		return orderReceived;
	}
	public void setOrderReceived(String orderReceived) {
		this.orderReceived = orderReceived;
	}
	
	public Status(int orderId, int customerId, String orderShipped, String orderReceived) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderShipped = orderShipped;
		this.orderReceived = orderReceived;
	}
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Status [orderId=" + orderId + ", customerId=" + customerId + ", orderShipped=" + orderShipped
				+ ", orderReceived=" + orderReceived + "]";
	}
	
	
	
	

}
