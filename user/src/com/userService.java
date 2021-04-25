package com;

import model.user;

import java.net.URISyntaxException;
import java.sql.SQLException;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	public Response insertItem(@FormParam("UserEmail") String UserEmail, 
	 @FormParam("firstName") String firstName, 
	 @FormParam("lastName") String lastName,
	 @FormParam("type") String type,
	 @FormParam("phone") String phone,
	 @FormParam("password") String password) 
	{ 
	 
		 itemObj.insertUser(UserEmail, firstName, lastName, type, phone, password);
	 	 
		 java.net.URI location = null;
		try {
			location = new java.net.URI("../../../user/accountCreated.jsp?A_User_Added");
			
		} catch (URISyntaxException e) {
			
			e.printStackTrace();
		}
		
		return Response.temporaryRedirect(location).build() ;
		
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
	
	
}
	