package com;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

import model.Products;
import model.UserMessage;
import model.addProduct;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/messageUser")
public class UserMessageService 
{
	    UserMessage msgObj = new UserMessage();
	    @GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		
		public String readMsg()
		{
			return msgObj.readMsg();
	    }
	 
	  
		@POST
		@Path("/AddMessage")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		
		public String insertMessage(@FormParam("ID") String ID,
		@FormParam("email") String email,
		@FormParam("subject") String subject,
		@FormParam("body") String body)
	
		{
		String output = msgObj.insertMessage(ID,email, subject, body);
		return output;
		}
}