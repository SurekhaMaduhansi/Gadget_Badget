package com;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import model.UserViewProduct;

@Path("/viewMyCart")
public class MyCartService {
	

		    UserViewProduct viewmycartObj = new UserViewProduct();
		
		  	 
		    @GET
			@Path("/")
			@Produces(MediaType.TEXT_HTML)
			
			public String readMyCart()
			{
				return viewmycartObj.readMyCart();
		    }
}
