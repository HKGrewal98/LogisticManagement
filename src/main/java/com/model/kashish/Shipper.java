package com.model.kashish;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.model.harkanwal.Orders;
import com.model.jay.Vehicle;

@Entity
@Table(name="shipper")
public class Shipper {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String companyName;
	private Date createdAt;
	private Date updatedAt;
	@ManyToOne
	@JoinColumn(name = "vehicleId")
	private Vehicle vehicle;
	@OneToOne
	@JoinColumn(name="orderId",referencedColumnName = "id")
	private Orders order;
	@OneToOne(mappedBy = "shipper",fetch = FetchType.EAGER)
	private Route route;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	@Override
	public String toString() {
		return "Shipper [id=" + id + ", companyName=" + companyName + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", vehicle=" + vehicle + " route=" + route + "]";
	}
}
