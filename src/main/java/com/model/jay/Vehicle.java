package com.model.jay;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.model.kashish.Shipper;

@Entity
@Table(name="vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String manufactureYear;
	private String model;
	private String vehicleNumber;
	private String color;
	private boolean isAvailable;
	
	@OneToMany(mappedBy = "vehicle")
	private List<Shipper> shipper;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getManufactureYear() {
		return manufactureYear;
	}
	public void setManufactureYear(String manufactureYear) {
		this.manufactureYear = manufactureYear;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public List<Shipper> getShipper() {
		return shipper;
	}
	public void setShipper(List<Shipper> shipper) {
		this.shipper = shipper;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", manufactureYear=" + manufactureYear + ", model=" + model + ", vehicleNumber="
				+ vehicleNumber + ", color=" + color + ", isAvailable=" + isAvailable + "]";
	}
	
	
	
}
