package com.dao.kashish;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.model.jay.Client;

public class ClientDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LMDB");
	
	 public Client getClientById(int clientId) {
			EntityManager em = factory.createEntityManager();
			try {
				String sql = "select c from Client c where c.id=%d";
				sql = String.format(sql,clientId);
	    		Query query = em.createQuery(sql);
	    		Client client = (Client) query.getSingleResult();
				return client;
			}catch(Exception ex) {
				 System.out.println("Exception is getting the client by id : " + ex);
				 return null;
			}finally {
				 em.close();
			}	
		 }
	 
	 public List<Client> getAllClients() {
			EntityManager em = factory.createEntityManager();
			try {
				String sql = "select c from Client c";
	    		Query query = em.createQuery(sql);
	    		List<Client> clientList =  query.getResultList();
				return clientList;
			}catch(Exception ex) {
				 System.out.println("Exception is getting all clients : " + ex);
				 return new ArrayList<>();
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
