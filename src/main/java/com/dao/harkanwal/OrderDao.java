package com.dao.harkanwal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dao.jay.InventoryDao;
import com.dao.kashish.ClientDao;
import com.harkanwal.DTO.OrderRequest;
import com.harkanwal.DTO.OrdersDTO;
import com.harkanwal.DTO.Response;
import com.model.harkanwal.Inventory;
import com.model.harkanwal.OrderDetails;
import com.model.harkanwal.Orders;
import com.model.harkanwal.Units;
import com.model.jay.Client;
import com.model.jay.Vehicle;

public class OrderDao {
	 EntityManagerFactory factory = Persistence.createEntityManagerFactory("LMDB");
	 ClientDao clientDao = new ClientDao();
	 InventoryDao inventoryDao = new InventoryDao();
	 
	 public Response createOrder(OrderRequest orderRequest) {
		EntityManager em = factory.createEntityManager();
		
		try {
			Client client = clientDao.getClientById(orderRequest.getClientId());
			Inventory item = inventoryDao.getItemById(orderRequest.getItemId());
			Units unit = Units.getUnit(orderRequest.getUnit());
			if(item.getQuantity()>=orderRequest.getQuantity() && item.getUnit().equals(unit)) {
				
				em.getTransaction().begin();
				Orders orders = new Orders();
				orders.setCreated_at(new Date(System.currentTimeMillis()));
				orders.setName(orderRequest.getOrderName());
				orders.setClient(client);
				
				OrderDetails orderDetails = new OrderDetails();
				orderDetails.setAmount(orderRequest.getQuantity());
				orderDetails.setUnit(unit);
				orderDetails.setInventory(item);
				orderDetails.setOrder(orders);
				
				em.persist(orders);
                em.persist(orderDetails); 
                
				em.getTransaction().commit();	
				
				inventoryDao.updateItem(orderRequest.getItemId(),item.getQuantity() - orderRequest.getQuantity());
				
				return new Response(true,"Order created successfully with id " + orders.getId() + " .");
				
			}else {
				return new Response(false,"Order can't be created. Either item quantity is insufficient or wrong quantity unit is selected.");
			}
			
		}catch(Exception ex) {
			 System.out.println("Exception is saving the order : " + ex);
			 return new Response(false,"Unknown error occured. Please try later.");
		}finally {
			 em.close();
		}	
	 }
	 
	 public List<Orders> getAllOrders() {
		EntityManager em = factory.createEntityManager();
		try {
			String sql = "select order from Orders order";
			Query query = em.createQuery(sql);
			List<Orders> ordersList = query.getResultList();
			return ordersList;		
		}catch(Exception ex) {
			 System.out.println("Exception in getting all orders : " + ex);
			 return new ArrayList<>();
		}finally {
			 em.close();
		}			 
	 }
	 
	 public Orders getOrderById(int orderId) {
			EntityManager em = factory.createEntityManager();
			try {
				String sql = "select order from Orders order where order.id=%d";
				sql = String.format(sql, orderId);
				Query query = em.createQuery(sql);
				Orders order = (Orders) query.getSingleResult();
				return order;		
			}catch(Exception ex) {
				 System.out.println("Exception in getting order by id : " + ex);
				 return null;
			}finally {
				 em.close();
			}			 
		 }
	 
	 public OrderDetails getOrderDetailsbyOrderId(int orderId) {
			EntityManager em = factory.createEntityManager();
			try {
				String sql = "select order from OrderDetails order where order.order=%d";
				sql = String.format(sql, orderId);
				Query query = em.createQuery(sql);
				OrderDetails order = (OrderDetails) query.getSingleResult();
				return order;		
			}catch(Exception ex) {
				 System.out.println("Exception in getting order details by order id : " + ex);
				 return null;
			}finally {
				 em.close();
			}			 
		 }
	 
	 
	 
	 
	 public List<OrdersDTO> getOrdersView() {
		 
		 List<Orders> ordersList = getAllOrders();
		 
		 List<OrdersDTO> ordersDTOList =  ordersList
				 .stream()
				 .map((order) -> {
					 OrderDetails details = getOrderDetailsbyOrderId(order.getId());
					 if(details==null) {
						 return null;
					 }
					 OrdersDTO od = new OrdersDTO();
					 StringBuilder sb = new StringBuilder("");
					 od.setId(order.getId());
					 od.setName(order.getName());
					 od.setClient(sb.append(order.getClient().getName())
							 .append(", ").append(order.getClient().getLocation())
							 .append(", ").append(order.getClient().getAddress()).toString());
					 od.setCreated_at(order.getCreated_at());
					 System.out.println(details);
					 od.setItem(details.getInventory().getName());
					 od.setQuantity(details.getAmount());
					 od.setUnit(details.getUnit().name());
					 od.setStatus(order.isCompleted()?"Completed":"Draft");
					 if(!od.getStatus().equals("Completed")){
						   if(order.getShipper()!=null) {
							   od.setStatus("In Progress");
						   }
					 }
					 
					 return od;
		          })
				 .filter(od -> Objects.nonNull(od))
				 .collect(Collectors.toList());
		 
		 ordersDTOList.forEach((order) -> System.out.println(order));
		 
		 return ordersDTOList;
	 }
	 
	 public OrdersDTO getCompleteDetailsByOrderId(int orderId) {
		 Orders order = getOrderById(orderId);
		 System.out.println("Order : " + order);
		 OrderDetails details = getOrderDetailsbyOrderId(order.getId());
		 if(details==null) {
			 return null;
		 }
		 OrdersDTO od = new OrdersDTO();
		 StringBuilder sb = new StringBuilder("");
		 StringBuilder sb1 = new StringBuilder("");
		 od.setId(order.getId());
		 od.setName(order.getName());
		 od.setClient(sb.append(order.getClient().getName())
				 .append(", ").append(order.getClient().getLocation())
				 .append(", ").append(order.getClient().getAddress()).toString());
		 od.setCreated_at(order.getCreated_at());
		 od.setItem(details.getInventory().getName());
		 od.setQuantity(details.getAmount());
		 od.setUnit(details.getUnit().name());
		 od.setStatus(order.isCompleted()?"Completed":"Draft");
		 if(order.getShipper()!=null) {
			 if(!od.getStatus().equals("Completed")){
				   od.setStatus("In Progress");
			 }
			 od.setShipperCompany(order.getShipper().getCompanyName());
			 Vehicle vehicle = order.getShipper().getVehicle();
			 od.setVehicle(sb1.append(vehicle.getVehicleNumber()).append(" ,")
					 .append(vehicle.getModel()).append(" ,")
					 .append(vehicle.getManufactureYear()).append(" ,")
					 .append(vehicle.getColor()).toString());
			 od.setStartLocation(order.getShipper().getRoute().getStartLocation());
			 od.setShippingStartDate(order.getShipper().getRoute().getStartDate());
			 od.setEndLocation(order.getShipper().getRoute().getEndLocation());
			 od.setShippingEndDate(order.getShipper().getRoute().getEndDate());
		 }
		 
		 return od;
	 }
	 
	
}

//EntityManager em = factory.createEntityManager();
//try {
//}catch(Exception ex) {
//	 System.out.println("Exception is : " + ex);
//}finally {
//	 em.close();
//}	
