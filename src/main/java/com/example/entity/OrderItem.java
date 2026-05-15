package com.example.entity;

public class OrderItem {
	private int orderId;
	private int productId;
	private String name;
	private int price;
	private int quantity;

	public OrderItem(int orderId, int productId, String name, int price, int quantity) {
		this.orderId = orderId;
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
}
