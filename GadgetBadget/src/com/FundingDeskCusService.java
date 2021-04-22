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
	

}
