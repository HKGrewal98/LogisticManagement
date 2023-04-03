package com.dao.jay;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.model.harkanwal.Inventory;

public class InventoryDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LMDB");
	
	
	public Inventory getItemById(int id) {
		EntityManager em = factory.createEntityManager();
		try {
			String sql = "select i from Inventory i where i.id=%d";
			sql = String.format(sql, id);
			Query query = em.createQuery(sql);
			Inventory inv = (Inventory) query.getSingleResult();
			return inv;
		}catch(Exception ex) {
			 System.out.println("Exception in fetching item by id : " + ex);
			 return null;
		}finally {
			 em.close();
		}	
	}
	
	public List<Inventory> getAllItems() {
		EntityManager em = factory.createEntityManager();
		try {
			String sql = "select i from Inventory i";
			Query query = em.createQuery(sql);
			List<Inventory> inventoryList = query.getResultList();
			return inventoryList;
		}catch(Exception ex) {
			 System.out.println("Exception in getting all items : " + ex);
			 return new ArrayList<>();
		}finally {
			 em.close();
		}	
	}
	
	public void updateItem(int id,int amount) {
		EntityManager em = factory.createEntityManager();
		try {
			String sql = "update Inventory i set i.quantity=%d where i.id=%d";
			sql = String.format(sql,amount,id);
			Query query = em.createQuery(sql);
			em.getTransaction().begin();
			int done = query.executeUpdate();
			em.getTransaction().commit();
			System.out.println("Quantity updated for id : " + id);
		}catch(Exception ex) {
			 System.out.println("Exception in updating item : " + ex);
		}finally {
			 em.close();
		}	
	}
	
	
	public void createItem(Inventory inventory) {
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(inventory);
			em.getTransaction().commit();
		}catch(Exception ex) {
			 System.out.println("Exception in creating item : " + ex);
		}finally {
			 em.close();
		}	
	}
	
    public void updateItem(Inventory inventory) {
    	EntityManager em = factory.createEntityManager();
    	try {
    		em.getTransaction().begin();
    		em.merge(inventory);
			em.getTransaction().commit();
    	}catch(Exception ex) {
    		 System.out.println("Exception in updating item : " + ex);
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
