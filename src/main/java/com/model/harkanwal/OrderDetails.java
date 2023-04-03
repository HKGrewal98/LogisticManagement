package com.model.harkanwal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int amount;
	
	@ManyToOne
	@JoinColumn(name = "inventoryId")
	Inventory inventory;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	Orders order;
	
	@Enumerated(EnumType.STRING)
	private Units unit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
	public Units getUnit() {
		return unit;
	}

	public void setUnit(Units unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", amount=" + amount + ", inventory=" + inventory + ", order=" + order + "unit=" + unit + "]";
	}
	
	
	
}
