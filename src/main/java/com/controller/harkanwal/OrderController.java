package com.controller.harkanwal;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.harkanwal.OrderDao;
import com.dao.jay.InventoryDao;
import com.dao.kashish.ClientDao;
import com.harkanwal.DTO.InventoryRequest;
import com.harkanwal.DTO.OrderRequest;
import com.harkanwal.DTO.Response;
import com.model.harkanwal.Inventory;
import com.model.harkanwal.Units;

@Controller
public class OrderController {
	
	private ClientDao clientDao = new ClientDao();
	private InventoryDao inventoryDao = new InventoryDao();
	private OrderDao orderDao = new OrderDao();
	 
	  @RequestMapping("/createOrderPage")
	    public ModelAndView createOrdersPage() {
	    	Map <String,Object> map = new HashMap<>();
	    	map.put("clientList",clientDao.getAllClients());
	    	map.put("inventoryList",inventoryDao.getAllItems());
	    	map.put("unitsList", Units.getAllUnits());
	    	map.put("orderRequest", new OrderRequest());
	    	
	    	return createResponse("createOrder",map);
	    }
	  
	   @RequestMapping(value = "/saveOrder",method=RequestMethod.POST)
	    public ModelAndView saveOrder(@ModelAttribute(name = "orderRequest") OrderRequest orderRequest) {
	    	Map <String,Object> map = new HashMap<>();
	    	System.out.println(orderRequest);
	    	Response res = orderDao.createOrder(orderRequest);
	    	map.put("message",res.getMessage());
	    	map.put("ordersList", orderDao.getOrdersView());
	    	return createResponse("mainPage",map);
	    }
	   
	   @RequestMapping(value="/allOrders")
	   public ModelAndView allOrders() {
		   Map <String,Object> map = new HashMap<>();
		   map.put("ordersList", orderDao.getOrdersView());
		   return createResponse("mainPage",map);
	   }
	   
	   @RequestMapping(value="/allItems")
	   public ModelAndView allItems() {
		   Map <String,Object> map = new HashMap<>();
		   map.put("itemsList", inventoryDao.getAllItems());
		   return createResponse("inventoryList",map);
	   }
	   
	   @RequestMapping("/createInventoryPage")
	   public ModelAndView createItemPage(@RequestParam(name = "update" , required = false) String op,
			                              @RequestParam(name = "itemId" , required = false) String itemId)
	   {
		   Map <String,Object> map = new HashMap<>();
		   boolean update = Boolean.parseBoolean(op);
		   map.put("unitsList", Units.getAllUnits());
		   
		   if(update) {
			      map.put("itemId", Integer.parseInt(itemId));
			      InventoryRequest iv = new InventoryRequest();
			      Inventory inventory = inventoryDao.getItemById(Integer.parseInt(itemId));
			      iv.setName(inventory.getName());
			      iv.setQuantity(inventory.getQuantity());
			      iv.setUnit(inventory.getUnit().name());
			      map.put("inventoryRequest",iv);    
		   }else {
			    map.put("itemId", 0);
			    map.put("inventoryRequest", new InventoryRequest());
		   }
		  
		   return createResponse("createInventory",map);
	   }
	   
	   @RequestMapping(value = "/saveInventory",method=RequestMethod.POST)
	   public ModelAndView saveInventory(@ModelAttribute(name = "inventoryRequest") InventoryRequest inventoryRequest) {
	    	Map <String,Object> map = new HashMap<>();
	    	System.out.println(inventoryRequest);
	    	if(inventoryRequest.getItemId()==0) {
	    		Inventory inv = new Inventory();
	    		inv.setName(inventoryRequest.getName());
	    		inv.setQuantity(inventoryRequest.getQuantity());
	    		inv.setUnit(Units.getUnit(inventoryRequest.getUnit()));
	    		inventoryDao.createItem(inv);
	    	}else {
	    		Inventory inv = inventoryDao.getItemById(inventoryRequest.getItemId());
	    		inv.setName(inventoryRequest.getName());
	    		inv.setQuantity(inventoryRequest.getQuantity());
	    		inventoryDao.updateItem(inv);
	    	}
	        map.put("itemsList", inventoryDao.getAllItems());
			return createResponse("inventoryList",map);
	    }
	   
	   @RequestMapping("/orderDetails/{orderId}")
	   public ModelAndView getAllDetails(@PathVariable(name = "orderId") int orderId) {
		   System.out.println("Order id : " + orderId);
		   Map <String,Object> map = new HashMap<>();
		   map.put("orderDetails", orderDao.getCompleteDetailsByOrderId(orderId));
		   return createResponse("orderDetails",map);
	   }
	  
	  
	    
	    public ModelAndView createResponse(String view,Map <String,Object> map) {
	    	ModelAndView mv = new ModelAndView(view);
	    	if(map!=null && map.size()>0) {
	    		map.forEach((key,value) -> mv.addObject(key, value));
	    	}
	    	return mv;
	    }
}// class ends...
