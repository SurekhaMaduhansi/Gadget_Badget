package com;

import java.sql.SQLException;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

import model.FundingDeskCus;
import model.Homes;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Homes")
public class HomesService {
	
	Homes homes = new Homes();
	
	@GET
	@Path("/AdminHome")
	@Produces(MediaType.TEXT_HTML)
	public String AdminHome()
	 {
		return homes.DisplayAdminHome();
	 }
	

	@GET
	@Path("/UserHome")
	@Produces(MediaType.TEXT_HTML)
	public String UserHome()
	 {
		return homes.DisplayUserHome();
	 }
	

}
