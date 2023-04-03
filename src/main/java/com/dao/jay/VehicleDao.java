package com.dao.jay;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.model.jay.Vehicle;

public class VehicleDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LMDB");
	
	public List<Vehicle> getAllVehicles() {
		EntityManager em = factory.createEntityManager();
		try {
			String sql = "select v from Vehicle v";
			Query query = em.createQuery(sql);
			List<Vehicle> vehicleList = query.getResultList();
			return vehicleList;
		}catch(Exception ex) {
			 System.out.println("Exception in getting all vehicles : " + ex);
			 return new ArrayList<>();
		}finally {
			 em.close();
		}	
	}
	
	
	public Vehicle getVehicleById(int vehicleId) {
		EntityManager em = factory.createEntityManager();
		try {
			String sql = "select v from Vehicle v where v.id=%d";
			sql = String.format(sql, vehicleId);
			Query query = em.createQuery(sql);
			return (Vehicle) query.getSingleResult();
		}catch(Exception ex) {
			 System.out.println("Exception in getting vehicle by id : " + ex);
			 return null;
		}finally {
			 em.close();
		}	
	}
	
	public void updateVehicleStatus(boolean isAvailable,int vehicleId) {
		EntityManager em = factory.createEntityManager();
		try {
			String sql = "update Vehicle v  set v.isAvailable=%s where v.id=%d";
			sql = String.format(sql, isAvailable,vehicleId);
			Query query = em.createQuery(sql);
			em.getTransaction().begin();
			query.executeUpdate();
			em.getTransaction().commit();
		    System.out.println("Vehicle status updated for id  " + vehicleId);
		}catch(Exception ex) {
			 System.out.println("Exception in getting vehicle status : " + ex);
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
