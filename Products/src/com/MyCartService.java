package com;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
		    

			/* Delete Product */
			@POST
			@Path("/DeleteProductCart")
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			@Produces(MediaType.TEXT_PLAIN)
			public String UserDeleteProduct(@FormParam("ID") String CID) throws SQLException
			{
				String output=viewmycartObj.UserDeleteProduct(CID);
				return output;
			}
			
}
