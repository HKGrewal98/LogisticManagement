package com.model.harkanwal;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.model.jay.Client;
import com.model.kashish.Shipper;

@Entity
@Table(name="orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Date created_at;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="clientId")
	private Client client;
	@OneToMany(mappedBy = "order")
	private List<OrderDetails> itemsList;
	private boolean isCompleted;
	@OneToOne(mappedBy = "order",fetch = FetchType.EAGER)
	private Shipper shipper;
	

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
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<OrderDetails> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<OrderDetails> itemsList) {
		this.itemsList = itemsList;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public Shipper getShipper() {
		return shipper;
	}
	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", name=" + name + ", created_at=" + created_at + ", client=" + client
				+" isCompleted="+isCompleted+" shipper="+shipper+ "]";
	}
	
	
	
}
