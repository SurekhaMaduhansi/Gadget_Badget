package com;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

import model.Products;
import model.addProduct;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/addProduct")
public class addProductService 
{
	    addProduct addproductObj = new addProduct();
	    
	    @GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		
		public String readForm()
		{
			return addproductObj.readForm();
	    }
	 
		
		@POST
		@Path("/AddProduct")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertItem(@FormParam("ID") String ID,
		@FormParam("name") String name,
		@FormParam("category") String category,
		@FormParam("Description") String Description,
		@FormParam("quantity") String quantity,
		@FormParam("price") String price,
		@FormParam("status") String status)
		{
		String output = addproductObj.insertItem(ID,name, category, Description, quantity,price,status);
		return output;
		}
}
