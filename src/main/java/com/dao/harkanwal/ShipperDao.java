package com.dao.harkanwal;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dao.jay.VehicleDao;
import com.harkanwal.DTO.Response;
import com.harkanwal.DTO.ShipmentRequest;
import com.model.harkanwal.Orders;
import com.model.jay.Vehicle;
import com.model.kashish.Route;
import com.model.kashish.Shipper;

public class ShipperDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LMDB");
	OrderDao orderDao = new OrderDao();
	VehicleDao vehicleDao = new VehicleDao();
	
	
	public Response validateRequest(ShipmentRequest shipmentRequest) {
		
		Date startDate = shipmentRequest.getStartDate();
		Date endDate = shipmentRequest.getEndDate();
		
		if(startDate.after(endDate)) {
			return new Response(false,"Error!! Start Date must be less than End Date.");
		}
		return new Response(true);
	}
	
	
	public Response saveShipment(ShipmentRequest shipmentRequest) {
		EntityManager em = factory.createEntityManager();
		try {
			Response res = validateRequest(shipmentRequest);
			if(!res.isSuccess()) {
				return new Response(false,res.getMessage());
			}
			
			Shipper shipper = new Shipper();
			Route route = new Route();
			
			Orders order = orderDao.getOrderById(shipmentRequest.getOrderId());
			Vehicle vehicle = vehicleDao.getVehicleById(shipmentRequest.getVehicleId());
			
			shipper.setCompanyName(shipmentRequest.getCompanyName());
			shipper.setCreatedAt(new Date(System.currentTimeMillis()));
			shipper.setUpdatedAt(new Date(System.currentTimeMillis()));
			shipper.setOrder(order);
			shipper.setVehicle(vehicle);
			
			
			route.setEndDate(shipmentRequest.getEndDate());
			route.setStartDate(shipmentRequest.getStartDate());
			route.setStartLocation(shipmentRequest.getStartLocation());
			route.setEndLocation(shipmentRequest.getEndLocation());
			route.setShipper(shipper);
			
			em.getTransaction().begin();
			em.persist(shipper);
			em.persist(route);
			em.getTransaction().commit();
			
			vehicleDao.updateVehicleStatus(false, shipmentRequest.getVehicleId());
			return new Response(true,"New shipment request created with id " + shipper.getId() + " .");
		}catch(Exception ex) {
			 System.out.println("Exception in creating new shipment : " + ex);
			 return new Response(false,"Unknown error occured.");
		}finally {
			 em.close();
		}	
	}

}
//EntityManager em = factory.createEntityManager();
//try {
//}catch(Exception ex) {
//	 System.out.println("Exception is : " + ex);
//}finally {
//	 em.close();
//}	
