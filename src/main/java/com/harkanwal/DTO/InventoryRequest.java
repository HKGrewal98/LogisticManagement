package com.harkanwal.DTO;

public class InventoryRequest {

	private String name;
	private int quantity;
	private String unit;
	private int itemId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "InventoryRequest [name=" + name + ", quantity=" + quantity + ", unit=" + unit + ", itemId=" + itemId
				+ "]";
	}
	
}
