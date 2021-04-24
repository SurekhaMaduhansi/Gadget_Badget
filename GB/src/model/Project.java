package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Project {
	
	private Connection connection()
	{
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			 //Provide the correct details: DBServer/DBName, username, password
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paf?useSSL=false", "root", "ABCroot@1");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
 	}
	
	public String insertProject( String ProjectCode, String ProjectName, String Description, String Budget, String Category, String UserEmail) {
		
		String output = "";
		try {
			
			Connection con = connection();
			 if (con == null)
			 {return "Error while connecting to the database for inserting."; }
			 // create a prepared statement
			 String query = " insert into projects (ProjectId,ProjectCode, ProjectName, Description, Budget, Category,UserEmail) values (?, ?, ?, ?, ?,?,?)";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setInt(1, 0);
			 preparedStmt.setString(2, ProjectCode);
			 preparedStmt.setString(3, ProjectName);
			 preparedStmt.setString(4, Description);
			 preparedStmt.setString(5, Budget);
			 preparedStmt.setString(6, Category);
			 preparedStmt.setString(7, UserEmail);
			 
			 preparedStmt.execute();
			 con.close();
			 
			 output = "Inserted Successfully";
			  
			
		} catch (Exception e) {
			// TODO: handle exception
			
			output = "Error while inserting the item.";
			 System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String readForm()
	 {
		
		 String output = "";
		
		 try
		 {
			Connection con = connection();
			
			if (con == null) 
			{return "Error while connecting to the database for reading."; }
			
			output ="<html>\r\n" + 
			 		"<head>\r\n" + 
			 		"<link rel=\"stylesheet\" href=\"../css/homee-style.css\">\r\n" + 
			 		"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
			 		"<script src='https://kit.fontawesome.com/a076d05399.js'></script>\r\n" + 
			 		"</head>\r\n" + 
			 		"    <!--Header-->\r\n" + 
			 		"    <br>\r\n" + 
			 		"    <div class=\"topnav sticky\">\r\n" + 
			 		"    \r\n" + 
			 		"         \r\n" + 
			 		"            <center></center>\r\n" + 
			 		"            <li><a  href=\"../../../GB/ProjectService/project_list/AddProject\">Add New Product <i class='fas fa-plus-square'></i></a></li>\r\n" + 
			 		"            <li><a href=\"../../../GB/ProjectService/project_list/load\">All Projects and Manage project details <i class='fab fa-elementor'></i></a>\r\n" + 
			 		
			 		"  \r\n" + 
			 		"          </div>\r\n" + 
			 		"                    \r\n" + 
			 		"              <div class=\"topnav sticky\"  >\r\n" + 
			 		"               <div class=\"search-container\">\r\n" + 
			 		"                <form action=\"searchHome.jsp\" method=\"post\">\r\n" + 
			 		"					    	<input type = \"text\" placeholder=\"Search Item\" name= \"search\">\r\n" + 
			 		"					    	<button type = \"Submit\">Search</button>\r\n" + 
			 		"					    \r\n" + 
			 		"					    </form>\r\n" + 
			 		"               \r\n" + 
			 		"             </div>\r\n" + 
			 		"            </div>\r\n" + 
			 		"           <br>\r\n" + 
			 		"\r\n" + 
			 		"<body>\r\n" + 
			 		"	\r\n" +  
			 		"			    \r\n" + 
			 		"\r\n" + 
			 		"		<center><div class=\"div1\">\r\n" + 
			 		"		<form action='../../../GB/ProjectService/project_list/AddProject'  method='post'><br><b>\r\n" + 
			 		"			<div class=\"card\">\r\n" + 
			 		" 				 <img src=\"dd.png\"  style=\"width:50%\">\r\n" + 
			 		"  					<div class=\"container\">\r\n" + 
			 		"  				</div>\r\n" + 
			 		"			</div>\r\n" + 
			 		"			<br><br>\r\n" +
			 		"			<input type=\"hidden\" name=\"ID\">" +
			 		"			Project Code<br> <input type =\"text\" name = \"ProjectCode\" placeholder = \"Enter the project code..\" required><br><br>\r\n" + 
			 		"			Project Name<br> <input type =\"text\" name = \"ProjectName\" placeholder = \"Enter the project name..\" required><br><br>\r\n" + 
			 		"			Project Category<br> <input type =\"text\" name = \"Category\" placeholder = \"Enter the project category..\" required><br><br>\r\n" + 
			 		"			Description<br> <input type =\"text\" name = \"Description\" required><br><br>\r\n" + 
			 		"			Budget<br> <input type =\"text\" name = \"Budget\" placeholder = \"Enter the budget value..\" required><br><br>"
			 		+ "\r\n"
			 					+ "<input type='hidden'  name='UserEmail' value='shehani@GB.com'>" + 
			 		"			<button class=\"button1\"><span>Add Project </span></button>\r\n" + 
			 		"				    \r\n" + 
			 		"		</form>\r\n" + 
			 		"		</div></center>\r\n" + 
			 		"		\r\n" + 
			 		"</body>\r\n" + 
			 		"</html>"; 
				
			
			
			
		 }
		 catch (Exception e)
		 {
			 output = "Error while reading the items.";
			 System.err.println(e.getMessage());
		 }
		 
		 return output;
		 
	 }
	public String readItems() {
		
		String output ="";
		
		try {
			
			Connection con = connection();
			
			if (con == null)
			 {return "Error while connecting to the database for reading."; }
			 // Prepare the html table to be displayed
			
			 output = "<table border='1'><tr><th>Project Id</th>"
			 + "<th>Project Code</th>" +
			 "<th>Project Name</th>" +
			 "<th>Category</th>" +
			 "<th>Description</th>" +
			 "<th>Budget</th>" +
			 "<th>Edit</th><th>Remove</th><th>Request for Funds</th></tr>";

			 String query = "select * from projects";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query); 
			 
			 while (rs.next())
			 {
			 String ProjectId = Integer.toString(rs.getInt("ProjectId"));
			 String ProjectCode = rs.getString("ProjectCode");
			 String ProjectName = rs.getString("ProjectName");
			 String Category = rs.getString("Category");
			 String Description = rs.getString("Description");
			 String Budget = rs.getString("Budget");
			 
			 
			 // Add into the html table
			 output += "<tr><td>" + ProjectId + "</td>";
			 output += "<td>" + ProjectCode + "</td>";
			 output += "<td>" + ProjectName + "</td>";
			 output += "<td>" + Category + "</td>";
			 output += "<td>" + Description+ "</td>";
			 output += "<td>" + Budget+ "</td>";
			 // buttons
			 output += "<td><form method = 'post' action='../../../GB/ProjectService/project_list/update'>"
					 +"<input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'>"
					  +"<input name='ProjectId' type='hidden' value='" + ProjectId+"'>"
					 +"</form>"
			 + "<td><form method='post' action='../../../GB/ProjectService/project_list/Delete'>"
			 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
			 + "<input name='ProjectId' type='hidden' value='" + ProjectId+"'>"
			 + "</form>"
			 + "<td><form method='post' action='project.jsp'>"
			 + "<input name='btnRequest' type='button' value = 'Request' class='btn btn-danger'>"
			 + "<input name='ProjectId' type='hidden' value='" + ProjectId
			 + "'>" + "</form></td></tr>";
			 } 
			 
			 con.close();
			 
			 output += "</table>";
			
		} catch (Exception e) {
			// TODO: handle exception
			
			output = "Error while reading the items.";
			System.err.println(e.getMessage()); 
		}
		return output;
	}
	
	public String updateProject(String ProjectId,String ProjectCode, String ProjectName, String Description, String Budget, String Category,String UserEmail) {
		
		String output ="";
		
		try {
			
			Connection con = connection();
			
			
			 if (con == null)
			 {return "Error while connecting to the database for updating."; }
			 // create a prepared statement
			 String query = "UPDATE projects SET ProjectCode=?,ProjectName=?,Description=?,Budget=?,Category=? WHERE ProjectId=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setString(1, ProjectCode);
			 preparedStmt.setString(2, ProjectName);
			 preparedStmt.setString(3, Description);
			 preparedStmt.setString(4, Budget);
			 preparedStmt.setString(5, Category);
			 preparedStmt.setInt(6, Integer.parseInt(ProjectId));
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Updated successfully"; 
			 
			} catch (Exception e) {
			// TODO: handle exception
				
				output = "Error while updating the item.";
				System.err.println(e.getMessage()); 
		}
		return output;
	}

	public String deleteProject(String ProjectId) {
		
		String output ="";
		
		try {
			
			Connection con = connection();
			 if (con == null)
			 {return "Error while connecting to the database for deleting."; }
			 
			 // create a prepared statement
			 String query = "delete from projects where ProjectId=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(ProjectId));
			 
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Deleted successfully";
			 
		} catch (Exception e) {
			// TODO: handle exception
			
			output = "Error while deleting the item.";
			System.err.println(e.getMessage()); 
		}
		
		return output;
		
	}
}
