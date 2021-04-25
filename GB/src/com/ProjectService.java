package com;

import java.sql.SQLException;

import model.Project;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/project_list")
public class ProjectService {
	
	Project project = new Project();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readForm() throws SQLException
	 {
	 return project.readForm();
	 }
	

	@POST
	@Path("/AddProject")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public String insertProject(@FormParam("ProjectCode") String ProjectCode,
			@FormParam("ProjectName") String ProjectName,
			@FormParam("Description") String Description,
			@FormParam("Budget") String Budget,
			@FormParam("Category") String Category,
			@FormParam("UserEmail") String UserEmail)
	{
		String output = project.insertProject(ProjectCode, ProjectName, Description, Budget, Category, UserEmail);
		return output;
		
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProject(String project_data_list)
	{
		//Convert the input string to a JSON object
		 JsonObject PObject = new JsonParser().parse(project_data_list).getAsJsonObject();
		 
		//Read the values from the JSON object
		 String ProjectId = PObject.get("ProjectId").getAsString();
		 String ProjectCode = PObject.get("ProjectCode").getAsString();
		 String ProjectName = PObject.get("ProjectName").getAsString();
		 String Description = PObject.get("Description").getAsString();
		 String Budget = PObject.get("Budget").getAsString();
		 String Category = PObject.get("Category").getAsString();
		 String UserEmail = PObject.get("UserEmail").getAsString();
		 String output = project.updateProject(ProjectId, ProjectCode, ProjectName, Description, Budget,Category,UserEmail);
		 
		return output;
	}
	
	@GET
	@Path("/load")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public String readItems() throws SQLException
	 {
	 return project.readItems();
	 }
	
	@POST
	@Path("/Delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public String deleteItem(String itemData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String ProjectId = doc.select("itemID").text();
	 String output = project.deleteProject(ProjectId);
	return output;
	}


			
}
