
package com;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.UserMessage;

@Path("/DeliveredView")
public class DeliveredOrdersViewService {
	

		    UserMessage delObj = new UserMessage();
		
		  	 
		    @GET
			@Path("/")
			@Produces(MediaType.TEXT_HTML)
			
			public String AdminReadDeliveredOr()
			{
				return delObj.AdminReadDeliveredOr();
		    }
}
