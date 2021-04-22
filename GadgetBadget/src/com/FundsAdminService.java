package com;

import model.Donations;
import model.FundsAdmin;

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

@Path("/FundsAdmin")
public class FundsAdminService {
	
	FundsAdmin fundRequests = new FundsAdmin();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readFundRequests()
	 {
		return fundRequests.readFundRequests();
	 }
	
	
	@POST
	@Path("/accept")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertAcceptedFunds(
	 @FormParam("UserEmail") String UserEmail,
	 @FormParam("ProjectID") int ProjectID,
	 @FormParam("amount") String amount,
	@FormParam("RequestID") String RequestID)
	{
	 String output = fundRequests.insertAcceptedFunds(UserEmail, ProjectID, amount,RequestID);
	 
	return output;
	}
	
	@POST
	@Path("/DeleteFundRequests")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public String Delete(@FormParam("RequestID") String RequestID) throws SQLException
	{
		String output = fundRequests.deleteFundRequests(RequestID);
		return output;

	}

}
