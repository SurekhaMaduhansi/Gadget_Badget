package com;


import model.log;

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

@Path("/log") 
public class logService {
	
	log itemObj = new log();

	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readLog() 
	{ 
		return itemObj.readLog(); 
	} 
}
	

