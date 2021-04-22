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
	


}
