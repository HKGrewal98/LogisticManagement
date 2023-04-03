package com.controller.jay;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.harkanwal.OrderDao;
import com.dao.harkanwal.ShipperDao;
import com.dao.jay.VehicleDao;
import com.harkanwal.DTO.Locations;
import com.harkanwal.DTO.OrderRequest;
import com.harkanwal.DTO.Response;
import com.harkanwal.DTO.ShipmentRequest;

@Controller
public class ShipperController {

	   private VehicleDao vehicleDao = new VehicleDao();
	   private ShipperDao shipperDao = new ShipperDao();
	   private OrderDao orderDao = new OrderDao();
	
	  @RequestMapping("/createShipmentPage")
	    public ModelAndView createOrdersPage(@RequestParam(name = "orderId") String orderId) {
	    	Map <String,Object> map = new HashMap<>();
	    	map.put("shipmentRequest", new ShipmentRequest());
	    	map.put("orderId",orderId);
	    	map.put("locationList", Locations.locationsList);
	    	map.put("vehicleList",vehicleDao.getAllVehicles());
	    	
	    	return createResponse("createShipment",map);
	    }
	  
	  @RequestMapping(value = "/saveShipment",method=RequestMethod.POST)
	    public ModelAndView saveShipment(@ModelAttribute(name = "shipmentRequest") ShipmentRequest shipmentRequest) {
	    	Map <String,Object> map = new HashMap<>();
	    	System.out.println(shipmentRequest);
	    	Response res = shipperDao.saveShipment(shipmentRequest);
	    	map.put("message", res.getMessage());
	    	map.put("ordersList", orderDao.getOrdersView());
	    	return createResponse("mainPage",map);
	    }
	    
	    public ModelAndView createResponse(String view,Map <String,Object> map) {
	    	ModelAndView mv = new ModelAndView(view);
	    	if(map!=null && map.size()>0) {
	    		map.forEach((key,value) -> mv.addObject(key, value));
	    	}
	    	return mv;
	    }
}
