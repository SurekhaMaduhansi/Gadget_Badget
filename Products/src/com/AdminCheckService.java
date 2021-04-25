package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.UserMessage;

@Path("/checkbill")
public class AdminCheckService {
	

		    UserMessage checkObj = new UserMessage();
		
		  	 
		    @GET
			@Path("/")
			@Produces(MediaType.TEXT_HTML)
			
			public String CheckOr()
			{
				return checkObj.CheckOr();
		    }
		    
		    @POST
			@Path("/addCancelStatus")
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			@Produces(MediaType.TEXT_PLAIN)
			public String insertCancelStatus(
			@FormParam("email") String email,
			@FormParam("ID") int ID,
			@FormParam("status") String status)

			{
			String output = checkObj.insertCancelStatus(email,ID,status);  
			return output;
			}
		    
		    
		    @POST
			@Path("/addDeliverStatus")
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			@Produces(MediaType.TEXT_PLAIN)
			public String insertDeliveredStatus(
			@FormParam("email") String email,
			@FormParam("ID") int ID,
			@FormParam("status") String status)

			{
			String output = checkObj.insertDeliveredStatus(email,ID,status);  
			return output;
			}
}
