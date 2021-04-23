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
		 String id = PObject.get("id").getAsString();
		 String pCodeString = PObject.get("p_id").getAsString();
		 String pNameString = PObject.get("proj_name").getAsString();
		 String pCatString = PObject.get("proj_category").getAsString();
		 String desString = PObject.get("proj_des").getAsString();
		 String budget = PObject.get("proj_budget").getAsString();
		 String output = project.updateProject(id, pCodeString, pNameString, pCatString, desString,budget);
		 
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
	public String Delete(@FormParam("ProjectId") String ProjectId) throws SQLException
	{
		String output = project.deleteProject(ProjectId);
		return output;

	}

			
}
