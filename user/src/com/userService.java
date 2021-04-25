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
@Path("/Postman \r\n" + 
		"Postman lets users create collections for their Postman API calls. Each collection can create subfolders and multiple requests. This helps in organizing the test suites.\r\n" + 
		"") 
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
	
	
	
	@PUT
	@Path("/updateUser") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateUser(String itemData) 
	{ 
	//Convert the input string to a JSON object 
	 JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject(); 
	//Read the values from the JSON object
	 String UserEmail = itemObject.get("UserEmail").getAsString(); 
	 String firstName = itemObject.get("firstName").getAsString(); 
	 String lastName = itemObject.get("lastName").getAsString(); 
	 String type = itemObject.get("type").getAsString(); 
	 String phone = itemObject.get("phone").getAsString();
	 String password = itemObject.get("password").getAsString(); 
	 
	 String output = itemObj.updateUser(UserEmail, firstName, lastName, type, phone,password); 
	return output; 
	}
	
	
	
	
	//postman
	//postman
	@POST
	@Path("/addPost") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertItempost(@FormParam("UserEmail") String UserEmail, 
	 @FormParam("firstName") String firstName, 
	 @FormParam("lastName") String lastName,
	 @FormParam("type") String type,
	 @FormParam("phone") String phone,
	 @FormParam("password") String password) 
	{ 
	 
		String output= itemObj.insertUser(UserEmail, firstName, lastName, type, phone, password);
	 	 
		
		
		return output;
		
	}
	
	
	@DELETE
	@Path("/DeletePostman") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteItem(String UserData) 
	{ 
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(UserData, "", Parser.xmlParser()); 
	 
	//Read the value from the element <itemID>
	 String UserEmail = doc.select("UserEmail").text(); 
	 String output = itemObj.deleteUser(UserEmail); 
	return output; 
	}
	
	
	
	
	
	
	
	
	
	
}
	