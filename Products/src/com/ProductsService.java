package com;

import java.sql.SQLException;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

import model.Products;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Products")
public class ProductsService 
{
	    Products productObj = new Products();
	    
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		
		public String readItems()
		{
			return productObj.readItems();
	    }
		
		@POST
		@Path("/Insert")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertItem(@FormParam("name") String name,
		@FormParam("category") String category,
		@FormParam("Description") String Description,
		@FormParam("quantity") String quantity,
		@FormParam("price") String price,
		@FormParam("status") String status)
		{
		String output = productObj.insertItem(name, category, Description, quantity,price,status);
		return output;
		}
		

		/* Update Product */
		@PUT
		@Path("/Update")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateItem(String itemData)
		{
		//Convert the input string to a JSON object
		JsonObject ProductObject = new JsonParser().parse(itemData).getAsJsonObject();
		//Read the values from the JSON object
		String ID = ProductObject.get("ID").getAsString();
		String name = ProductObject.get("name").getAsString();
		String category = ProductObject.get("category").getAsString();
		String Description = ProductObject.get("Description").getAsString();
		String quantity = ProductObject.get("quantity").getAsString();
		String price = ProductObject.get("price").getAsString();
		String status = ProductObject.get("status").getAsString();
		String output = productObj.updateProduct(ID, name, category, Description, quantity,price,status);
		return output;
		}
		
		
		/* Delete Product */
		@POST
		@Path("/Delete")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String Delete(@FormParam("ID") String ID) throws SQLException
		{
			String output=productObj.deleteProduct(ID);
			return output;
		}
		
}
