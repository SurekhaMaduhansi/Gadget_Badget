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

@Path("/bill")
public class BillService {
	

		    UserViewProduct billObj = new UserViewProduct();
		
		  	 
		    @GET
			@Path("/")
			@Produces(MediaType.TEXT_HTML)
			
			public String readBill()
			{
				return billObj.readBill();
		    }
		    
			@POST
			@Path("/InsertBillDetails")
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			@Produces(MediaType.TEXT_PLAIN)
			public String insertBill(@FormParam("address") String address,
			@FormParam("city") String city,
			@FormParam("mobile_number") String mobile_number,
			@FormParam("payment_method") String payment_method,
			@FormParam("transaction_id") String transaction_id)
		
			{
			String output = billObj.insertBill(address, city, mobile_number, payment_method,transaction_id);
			return output;
			}
			

}
