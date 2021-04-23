package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Products;
import model.UserHome;


@Path("/AllProducts")
public class UserHomeService 
{
	    UserHome userHomeObj = new UserHome();
	    
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		
		public String readAllProducts()
		{
			return userHomeObj.readAllProduct();
	    }
		

		 
		@POST
		@Path("/AddCart")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertCart(@FormParam("email") String email,
		@FormParam("ID") int ID,
		@FormParam("quantity") int quantity,
		@FormParam("price") String price,
		@FormParam("total") String total)

		{
		String output = userHomeObj.insertCart(email,ID, quantity, price);  
		return output;
		}
		
}