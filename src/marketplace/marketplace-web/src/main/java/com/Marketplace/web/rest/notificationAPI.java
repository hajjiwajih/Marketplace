package com.Marketplace.web.rest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.Marketplace.web.NotificationBean;


@Path("/notification")
@RequestScoped
public class notificationAPI {
	
	@EJB
	NotificationBean metier ;
	

	   @GET 
	   @Path("/start") 
	   @Produces(MediaType.APPLICATION_XML) 
	   
	   public String start() { 
	      return metier.StartTime(); 
	   }  
	   
	   @GET 
	   @Path("/stop") 
	   @Produces(MediaType.APPLICATION_XML) 
	   
	   public String End() { 
	      return metier.StopTime(); 
	   }  
	   
	   
	   

}
