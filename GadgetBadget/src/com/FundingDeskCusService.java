package com;


import model.Donations;
import model.FundingDeskCus;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/FundingDeskCus")
public class FundingDeskCusService {
	
FundingDeskCus FundingObject = new FundingDeskCus();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readDonations()
	 {
		return FundingObject.readProjects();
	 }
	
	
	@GET
	@Path("/readMyProjects")
	@Produces(MediaType.TEXT_HTML)
	public String readMyProjects()
	 {
		return FundingObject.readMyProjects();
	 }
	
	@POST
	@Path("/insertFundRequests")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertFundRequests(@FormParam("RequestID") String RequestID,
	 @FormParam("UserEmail") String UserEmail,
	 @FormParam("ProjectID") int ProjectID,
	 @FormParam("BankCardNumber") String BankCardNumber)
	{
	 String output = FundingObject.insertFundRequests(UserEmail, ProjectID,BankCardNumber);
	 return output;
	}
	

}
