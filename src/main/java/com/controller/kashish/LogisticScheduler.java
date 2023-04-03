package com.controller.kashish;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.scheduling.annotation.Scheduled;

import com.dao.harkanwal.OrderDao;
import com.dao.harkanwal.ShipperDao;
import com.dao.jay.VehicleDao;
import com.model.harkanwal.Orders;
import com.model.jay.Vehicle;

public class LogisticScheduler {
	
	private String sql1 = "select order from Orders order where order.isCompleted=false";
	private EntityManagerFactory factory;
	private EntityManager em;
	
	@Scheduled(fixedRate=60000)
	public void finishOrders(){
		 factory = Persistence.createEntityManagerFactory("LMDB");
		 em= factory.createEntityManager();
		 try {
			 Query query = em.createQuery(sql1);
			 List<Orders> ordersList = query.getResultList();
			 
			 ordersList
			 .stream()
			 .filter(order-> Objects.nonNull(order.getShipper()))
			 .forEach(order->updateRecords(order));
			
		 }catch(Exception ex){
			 System.out.println("Error in scheduler : " + ex);
		 }finally {
			 em.close();
			 factory.close();
		 }
		 
		 
	}// finishOrders ends.....
	
	public void updateRecords(Orders order) {
		
		em.getTransaction().begin();
		
		order.setCompleted(true);
		Vehicle vehicle = order.getShipper().getVehicle();
		vehicle.setAvailable(true);
		
		em.merge(order);
		em.merge(vehicle);
		
		em.getTransaction().commit();
		
		System.out.println("Order updated : " + order);
	}
	
}// class ends....
