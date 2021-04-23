package com;

import model.user;


import java.sql.SQLException;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*; 
//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 
@Path("/user") 
public class userService 
{ 
	user itemObj = new user(); 
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	
	public String readUser() 
	{ 
		return itemObj.readUser(); 
	} 
	
	
	@POST
	@Path("/add") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertItem(@FormParam("UserEmail") String UserEmail, 
	 @FormParam("firstName") String firstName, 
	 @FormParam("lastName") String lastName,
	 @FormParam("type") String type,
	 @FormParam("phone") String phone,
	 @FormParam("password") String password) 
	{ 
	 String output = itemObj.insertUser(UserEmail, firstName, lastName, type, phone, password);
	return output; 
	}
	

	//delete user Details:
	@POST
	@Path("/Delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public String Delete(@FormParam("UserEmail")String UserEmail) throws SQLException
	{
		String output=itemObj.deleteUser(UserEmail);
		return output;
	}
	
	
	
	@POST
	@Path("/view") 
	@Produces(MediaType.TEXT_HTML) 
	public String ViewMyDetails(@FormParam("UserEmail") String UserEmail) 
	{ 
		return itemObj.ViewMyDetails(UserEmail); 
	} 
	
	
	
}
	