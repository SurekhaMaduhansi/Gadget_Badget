package com;
import java.sql.SQLException;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

import model.Products;
import model.UserViewProduct;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;



@Path("/UserCart")
public class UserViewProductService {
	
	UserViewProduct cartObj = new UserViewProduct();
	    
			@GET
			@Path("/")
			@Produces(MediaType.TEXT_HTML)
			
			public String readProducts()
			{
				return cartObj.readProducts();
		    }
		
}
