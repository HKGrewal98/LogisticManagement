package com.controller.kashish;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.harkanwal.OrderDao;
import com.dao.harkanwal.ShipperDao;
import com.dao.jay.InventoryDao;
import com.dao.kashish.ClientDao;
import com.harkanwal.DTO.OrderRequest;
import com.harkanwal.DTO.Response;
import com.harkanwal.DTO.ShipmentRequest;
import com.model.harkanwal.Inventory;
import com.model.harkanwal.OrderDetails;
import com.model.harkanwal.Orders;
import com.model.harkanwal.Units;
import com.model.jay.Client;
import com.model.jay.Vehicle;
import com.model.kashish.Route;
import com.model.kashish.Shipper;

@Controller
public class LoginController {

	      private String userName="root";
	      private String password="root";
	      private OrderDao ordersDao = new OrderDao();
	
	    @RequestMapping("/login")
	    public ModelAndView loginPage(HttpServletRequest request) {
	    	Map <String,Object> map = new HashMap<>();
	    	map.put("name", "Harkanwal Grewal");
	    	HttpSession session = request.getSession();
	    	session.removeAttribute("login");
	    	return createResponse("login",map);
	    }
	    
	    @RequestMapping(value="/signIn",method=RequestMethod.POST)
	    public ModelAndView SignIn(@RequestBody MultiValueMap<String,String> formData,HttpServletRequest request) {
	    	Map <String,Object> map = new HashMap<>();
	    	String user = formData.get("user").get(0);
	    	String pass = formData.get("password").get(0);
	    	
	    	if(user.equals(user) && pass.equals(password)) {
	    		HttpSession session = request.getSession();
		    	session.setAttribute("login", "true");
		    	map.put("ordersList", ordersDao.getOrdersView());
		    	return createResponse("mainPage",map);
	    	}
	    	map.put("message", "Invalid username/password.");	
	    	return createResponse("login",map);
	    }
	    
	    @RequestMapping(value="/logout",method=RequestMethod.GET)
	    public ModelAndView logout(HttpServletRequest request) {
	    	Map <String,Object> map = new HashMap<>();
	    	HttpSession session = request.getSession();
	    	session.removeAttribute("login");
	    	return createResponse("login",map);
	    }
	    
	    public ModelAndView createResponse(String view,Map <String,Object> map) {
	    	ModelAndView mv = new ModelAndView(view);
	    	if(map!=null && map.size()>0) {
	    		map.forEach((key,value) -> mv.addObject(key, value));
	    	}
	    	return mv;
	    }
	    
	    public void code8() {
	    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LMDB");
	    	EntityManager em = factory.createEntityManager();
	    	try {
	    	     
	    		ShipmentRequest sr = new ShipmentRequest();
	    		sr.setCompanyName("Logistic Turbo");
	    		sr.setOrderId(6);
	    		sr.setVehicleId(1);
	    		sr.setEndDate(new Date(System.currentTimeMillis()) );
	    		sr.setEndLocation("Quebec");
	    		sr.setStartDate(new Date(System.currentTimeMillis()));
	    		sr.setStartLocation("Mississuaga");
	    		
	    		ShipperDao sd = new ShipperDao();
	    		Response res = sd.saveShipment(sr);
	    		System.err.println(res);
	    		
	    	}catch(Exception ex) {
	    		 System.out.println("Exception is : " + ex);
	    	}finally {
	    		 em.close();
	    		 factory.close();
	    	}	
	    }
	    
	    
	    public void code7() {
	    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LMDB");
	    	EntityManager em = factory.createEntityManager();
	    	try {
	    		OrderRequest  or = new OrderRequest();
	    		or.setClientId(3);
	    		or.setOrderName("Orange-GO");
	    		or.setItemId(1);
	    		or.setQuantity(10);
	    		or.setUnit("kg");
	    		
	    		OrderDao od = new OrderDao();
	    		Response res= od.createOrder(or);
	    		System.out.println(res);
	    		
	    	}catch(Exception ex) {
	    		 System.out.println("Exception is : " + ex);
	    	}finally {
	    		 em.close();
	    		 factory.close();
	    	}	
	    }
	    
	    
	    public void code() {
	    	 EntityManagerFactory factory = Persistence.createEntityManagerFactory("LMDB");
	    	 EntityManager em = factory.createEntityManager();
	    	 try {
	    		 Client client = new Client();
	    		 client.setName("Reliance");
	    		 client.setLocation("Mumbai");
	    		 client.setAddress("232, Sea Road, Bandra");
	    		 client.setPhoneNumber("6893219354");
	    		 
	    		 Orders order = new Orders();
	    		 order.setName("Coal");
	    		 order.setCreated_at(new Date(System.currentTimeMillis()));
	    		 
	    		 List<Orders> ordersList = new ArrayList<>();
	    		 ordersList.add(order);
	    		 
	    		 client.setOrders(ordersList);
	    		 order.setClient(client);
	    		 
	    		 em.getTransaction().begin();
	    		 em.persist(client);
	    		 em.persist(order);
                 em.getTransaction().commit();
                 
                 System.out.println("Order Id : " + order.getId());
	    		 
	    	 }catch(Exception ex) {
	    		 System.out.println("Exception is : " + ex);
	    	 }finally {
	    		 em.close();
	    		 factory.close();
	    	 }
	    }
	    
	    
	    
	    public void code2() {
	    	 EntityManagerFactory factory = Persistence.createEntityManagerFactory("LMDB");
	    	 EntityManager em = factory.createEntityManager();
	    	 try {
	    		 String sql = "select c from Client c where c.id=3";
	    		 Query query = em.createQuery(sql);
	    		 Client client = (Client) query.getSingleResult();
	    		 System.out.println("Client Id " + client.getId() + " Size: " + client.getOrders().size());
	    		 
	    		 Orders order = new Orders();
	    		 order.setName("Oranges");
	    		 order.setCreated_at(new Date(System.currentTimeMillis()));
	    		 
	    		
	    		 order.setClient(client);
	    		 
	    		 em.getTransaction().begin();
	    		 em.persist(order);
	    		 em.getTransaction().commit();
	    		 
	    		 
	    	 }catch(Exception ex) {
	    		 System.out.println("Exception is : " + ex);
	    	 }finally {
	    		 em.close();
	    		 factory.close();
	    	 }	
	    }
	    
	    public void code3() {
	    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LMDB");
	    	EntityManager em = factory.createEntityManager();
	    	try {
	    		String sql = "select c from Client c where c.id=3";
	    		Query query = em.createQuery(sql);
	    		Client client = (Client) query.getSingleResult();
	    		client.getOrders().forEach((e)->System.out.println(e));
	    		
	    		sql = "select c from Orders c where c.id=3";
	    		query = em.createQuery(sql);
	    		Orders order = (Orders) query.getSingleResult();
	    		System.out.println(order);
	    		
	    		sql = "select c from OrderDetails c where c.id=1";
	    		query = em.createQuery(sql);
	    		OrderDetails orderDetails = (OrderDetails) query.getSingleResult();
	    		System.out.println(orderDetails);
	    		
	    		
	    	}catch(Exception ex) {
	    		 System.out.println("Exception is : " + ex);
	    	}finally {
	    		 em.close();
	    		 factory.close();
	    	}	
	    	}
	    
	    
	    public void code4() {
	    	
	    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LMDB");
	    	EntityManager em = factory.createEntityManager();
	    	try {
	    		String sql = "select c from Orders c where c.id=1";
	    		Query query = em.createQuery(sql);
	    		Orders order = (Orders) query.getSingleResult();
	    		
	    		Inventory inv = new Inventory();
	    		inv.setName("Coal");
	    		inv.setQuantity(1000);
	    		inv.setUnit(Units.TONS);
	    		
	    		OrderDetails od = new OrderDetails();
	    		od.setAmount(100);
	    		od.setUnit(Units.TONS);
	    		od.setInventory(inv);
                od.setOrder(order);	
                
                List<OrderDetails> odList = new ArrayList<>();
                odList.add(od);
                
                inv.setOrders(odList);
                order.setItemsList(odList);
                
	    		
                em.getTransaction().begin();
                em.persist(inv);
                em.persist(od);
                em.getTransaction().commit();
	    		
	    		
	    		
	    	}catch(Exception ex) {
	    		 System.out.println("Exception is : " + ex);
	    	}finally {
	    		 em.close();
	    		 factory.close();
	    	}	
	    	}  	
	    
	    
	    
	    private void code5() {
	    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LMDB");
	    	EntityManager em = factory.createEntityManager();
	    	try {
	    		
	    		String sql = "select c from Orders c where c.id=1";
	    		Query query = em.createQuery(sql);
	    		Orders order = (Orders) query.getSingleResult();
	    		
	    		 sql = "select c from Vehicle c where c.id=1";
	    		 query = em.createQuery(sql);
	    		 Vehicle vehicle = (Vehicle) query.getSingleResult();
	    		  
	    		 Shipper shipper = new Shipper();
	    		 shipper.setCompanyName("Logistic Chargers");
	    		 shipper.setCreatedAt(new Date(System.currentTimeMillis()));
	    		 shipper.setUpdatedAt(new Date(System.currentTimeMillis()));
	    		 shipper.setOrder(order);
	    		 shipper.setVehicle(vehicle);
	    		 
	    		 
	    		 Route route = new Route();
	    		 route.setStartDate(new Date(System.currentTimeMillis()));
	    		 route.setEndDate(new Date(System.currentTimeMillis()));
	    		 route.setStartLocation("Toronto");
	    		 route.setEndLocation("California");
	    		 route.setShipper(shipper);
	    		 
	    		 em.getTransaction().begin();
	    		 em.persist(shipper);
	    		 em.persist(route);
	    		 em.getTransaction().commit();
	    		
	    	}catch(Exception ex) {
	    		 System.out.println("Exception is : " + ex);
	    	}finally {
	    		 em.close();
	    		 factory.close();
	    	}	
	    }
	    
	    
	    private void code6() {
	    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LMDB");
	    	EntityManager em = factory.createEntityManager();
	    	try {
	    		String sql = "select c from Orders c where c.id=1";
	    		Query query = em.createQuery(sql);
	    		Orders order = (Orders) query.getSingleResult();
	    		System.out.println(order);
	    		
				 sql = "select c from Shipper c where c.id=1";
				 query = em.createQuery(sql);
				 Shipper shipper = (Shipper) query.getSingleResult();
				 System.out.println(shipper);
	    		
	    		
	    	}catch(Exception ex) {
	    		 System.out.println("Exception is : " + ex);
	    	}finally {
	    		 em.close();
	    		 factory.close();
	    	}	
	    }
	    
	    
	  
}// class ends...


//EntityManagerFactory factory = Persistence.createEntityManagerFactory("LMDB");
//EntityManager em = factory.createEntityManager();
//try {
//}catch(Exception ex) {
//	 System.out.println("Exception is : " + ex);
//}finally {
//	 em.close();
//	 factory.close();
//}	



