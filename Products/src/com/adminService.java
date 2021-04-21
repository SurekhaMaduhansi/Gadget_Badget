package com;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

import model.Products;
import model.admin;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/admins")
public class adminService {
	admin adminObj = new admin();
    
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	
	public String readItems()
	{
		return adminObj.readItems();
    }

}
