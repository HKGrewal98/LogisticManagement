package com.harkanwal.DTO;

import java.sql.Date;


public class OrdersDTO {

	private int id;
	private String name;
	private String client;
	private Date created_at;
	private String item;
	private int quantity;
	private String unit;
	private String status;
	private String shipperCompany;
	private String vehicle;
	private String startLocation;
	private String endLocation;
	private Date shippingStartDate;
	private Date shippingEndDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getShipperCompany() {
		return shipperCompany;
	}
	public void setShipperCompany(String shipperCompany) {
		this.shipperCompany = shipperCompany;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}
	public String getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}
	public Date getShippingStartDate() {
		return shippingStartDate;
	}
	public void setShippingStartDate(Date shippingStartDate) {
		this.shippingStartDate = shippingStartDate;
	}
	public Date getShippingEndDate() {
		return shippingEndDate;
	}
	public void setShippingEndDate(Date shippingEndDate) {
		this.shippingEndDate = shippingEndDate;
	}
	@Override
	public String toString() {
		return "OrdersDTO [id=" + id + ", name=" + name + ", client=" + client + ", created_at=" + created_at
				+ ", item=" + item + ", quantity=" + quantity + ", unit=" + unit + ", status=" + status
				+ ", shipperCompany=" + shipperCompany + ", vehicle=" + vehicle + ", startLocation=" + startLocation
				+ ", endLocation=" + endLocation + ", shippingStartDate=" + shippingStartDate + ", shippingEndDate="
				+ shippingEndDate + "]";
	}
	
}
