package com.Marketplace.web.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Localimage;
import services.LocalimageManagment;



@Path("/localimages")
@RequestScoped
public class LocalimageApi {
	
	@EJB
	private LocalimageManagment metier ;
	
	   @GET 
	   @Path("/image") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public List<Localimage> getLocalImage(){ 
	      return metier.getAllImagess(); 
	   }  
	   
	   
		@GET
		@Path(value="/imageParName/{name}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Localimage> GetByName (@PathParam(value="name")String X)
		{
			return metier.getImagesByName(X);
		}
		
	   
}


