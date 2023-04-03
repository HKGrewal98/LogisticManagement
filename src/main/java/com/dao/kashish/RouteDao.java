package com.dao.kashish;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.model.kashish.Route;

public class RouteDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LMDB");
	
	public Route getRouteByShipperId(int shipperId) {
		EntityManager em = factory.createEntityManager();
		try {
			String sql = "select r from Route r where r.shipperId=%d";
			sql = String.format(sql, shipperId);
			Query query = em.createQuery(sql);
			return (Route) query.getSingleResult();
		}catch(Exception ex) {
			 System.out.println("Exception is : " + ex);
			 return null;
		}finally {
			 em.close();
		}	
	}
	
}
