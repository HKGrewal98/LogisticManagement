package com.harkanwal.DTO;

public class OrderRequest {

	private int clientId;
	private String orderName;
	private int itemId;
	private int quantity;
	private String unit;
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	@Override
	public String toString() {
		return "OrderRequest [clientId=" + clientId + ", orderName=" + orderName + ", itemId=" + itemId + ", quantity="
				+ quantity + ", unit=" + unit + "]";
	}
}
