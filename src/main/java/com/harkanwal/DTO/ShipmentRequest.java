package com.harkanwal.DTO;

import java.sql.Date;

public class ShipmentRequest {

	private String companyName;
	private int vehicleId;
	private int orderId;
	private String startLocation;
	private String endLocation;
	private Date startDate;
	private Date endDate;
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "ShipmentRequest [companyName=" + companyName + ", vehicleId=" + vehicleId + ", orderId=" + orderId
				+ ", startLocation=" + startLocation + ", endLocation=" + endLocation + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
}
