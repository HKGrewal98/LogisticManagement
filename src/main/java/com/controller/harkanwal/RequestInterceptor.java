package com.controller.harkanwal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestInterceptor implements HandlerInterceptor   {

	private List<String> allowedURLs = List.of("/LogisticManagement/login","/LogisticManagement/signIn");
	private boolean DISABLE_AUTH = false;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("INTERCEPTOR");
		
		if(DISABLE_AUTH) {
			return true;
		}
		
		if(!allowedURLs.contains(request.getRequestURI())) {
			  System.out.println("Checking the session value");
		      HttpSession session = request.getSession();
		      boolean login = Boolean.parseBoolean((String) session.getAttribute("login"));
		      System.out.println("Session attribute value is : " + login);
		      if(!login) {
		    	  System.out.println("Redirecting the request to the login Page.");
		    	  response.sendRedirect("login");
		    	  return false;
		      }
		}
		
		return true;
	}

	

}
