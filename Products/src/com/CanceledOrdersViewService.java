package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.UserMessage;

@Path("/CanceledView")
public class CanceledOrdersViewService {
	

		    UserMessage canObj = new UserMessage();
		
		  	 
		    @GET
			@Path("/")
			@Produces(MediaType.TEXT_HTML)
			
			public String AdminReadCanceledOr()
			{
				return canObj.AdminReadCanceledOr();
		    }
		    
			 
			
}
