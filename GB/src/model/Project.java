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
			
			 output = "<html>\r\n" + 
						"<head>\r\n" + 
						"<meta charset=\"ISO-8859-1\">\r\n" + 
						"\r\n" + 
						"	<link rel=\"stylesheet\" href=\"Home.css\">\r\n" + 
						"	<!-- bootstrap -->\r\n" + 
						"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
						"		\r\n" + 
						"	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" \r\n" + 
						"			integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n" + 
						"	\r\n" + 
						"	<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">	\r\n" + 
						"		\r\n" + 
						"		\r\n" + 
						"	<!-- bootstrap -->\r\n" + 
						"<title>GadgetBadget</title>\r\n" + 
						"</head>\r\n" + 
						"\r\n" + 
						"<body>\r\n" + 
						"\r\n" + 
						"<!-- navigation bar -->\r\n" + 
						"\r\n" + 
						"  <nav  class=\"navbar fixed-top navbar-white bg-white\">\r\n" + 
						"		<div class= \"container\">\r\n" + 
						"			<a class=\"navbar-brand\" href=\"#\">\r\n" + 
						"     			 <img src=\"../images/Capture.PNG\" alt=\"logo\" width=\"220\" height=\"78\" float=\"left\">\r\n" + 
						"   			</a>\r\n" + 
						"   			<br>\r\n" + 
						"   			<div class=\"topnav\" id=\"myTopnav\">\r\n" + 
						"			  <a href=\"\" >Home</a>\r\n" + 
						"			  <a href=\"#\">Products</a>\r\n" + 
						"			  <a href=\"\" class=\"active\">Donations</a>\r\n" + 
						"			  <a href=\"\">Funding HelpDesk</a>\r\n" + 
						"			  <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\">\r\n" + 
						"			    <i class=\"fa fa-bars\"></i>\r\n" + 
						"			  </a>\r\n" + 
						"			\r\n" + 
						"			</div>\r\n" + 
						"			\r\n" + 
						"			<button class=\"btn\"><i class=\"fa fa-shopping-cart\" style=\"font-size:24px\"></i></button>\r\n" + 
						"      \r\n" + 
						"			<div class=\"dropdown\">\r\n" + 
						"			   <img src=\"../images/avatar.png\" class=\"img-fluid\" alt=\"avatar1\" width=\"50\" height=\"80\" >\r\n" + 
						"			  <div class=\"dropdown-content\">\r\n" + 
						"			    <a href=\"#\">Profile</a>\r\n" + 
						"			    <a href=\"\">Log Out</a>\r\n" + 
						"			  </div>\r\n" + 
						"			</div>			\r\n" + 
						"		</div>	\r\n" + 
						"	</nav>\r\n" + 
						"	\r\n" + 
						"<!-- navigation bar -->\r\n" + 
						"	<br>\r\n" + 
						"  <img class=\"card-img-top\" src=\"../images/adminpage.jpg\" alt=\"Card image cap\"  height=\"500px\">\r\n" + 
						"  <br><br><br>"
						+"<center><table class=\"table\" style=\"width:850px\"><thead><tr><th>Project Id</th>\""+
				
			 "<th scope=\"col\">Project Code</th>" +
			 "<th scope=\"col\">Project Name</th>" +
			 "<th scope=\"col\">Category</th>" +
			 "<th scope=\"col\">Description</th>" +
			 "<th scope=\"col\">Budget</th>" +
			 "<th scope=\"col\">Edit</th><th scope=\"col\">Remove</th><th scope=\"col\">Request for Funds</th></tr>";

			 String query = "select * from projects";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query); 
			 

				// iterate through the rows in the result set
			 
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
			 
			 output += "</table><center><br><br>"
			 		+ "	<footer class=\"page-footer font-small color-dark\" style=\"background-color:#1f3a93\">\r\n" +
			 			"\r\n" + 
			 		"  <div style=\"background-color: #59abe3;\">\r\n" + 
			 		"    <div class=\"container\">\r\n" + 
			 		"\r\n" + 
			 		"      <!-- Grid row-->\r\n" + 
			 		"	<div class=\"row py-4 d-flex align-items-center\">\r\n" +
			 		"\r\n"+
			 		 " <!-- Grid column -->\r\n" +
			 		"        <div class=\"col-md-6 col-lg-5 text-center text-md-left mb-4 mb-md-0\">\r\n" + 
			 		"          <h6 class=\"mb-0\" style=\"color:white\">Get connected with us on social networks!</h6>\r\n" + 
			 		"        </div>\r\n" + 
			 		"        <!-- Grid column -->\r\n" + 
			 		"\r\n" + 
			 		"        <!-- Grid column -->\r\n" +
			 		"        <div class=\"col-md-6 col-lg-7 text-center text-md-right\">\r\n" + 
			 		"\r\n" + 
			 		"          <!-- Facebook -->\r\n" +
			 		"          <a class=\"fa fa-facebook\"></a>\r\n" + 
			 		"          <!-- Twitter -->\r\n" +
			 		"          <a class=\"fa fa-twitter \"></a>\r\n" +
			 		"          <!-- Google +-->\r\n" + 
			 		"          <a class=\"fa fa-google-plus-g\"></a>\r\n" + 
			 		"          <!--Linkedin -->\r\n" +
			 		"          <a class=\"fa fa-linkedin\"></a>\r\n" + 
			 		"          <!--Instagram-->\r\n" + 
			 		"          <a class=\"fa fa-instagram \"> </a>\r\n" + 
			 		"\r\n" + 
			 		"        </div>\r\n" + 
			 		"        <!-- Grid column -->\r\n" + 
			 		"\r\n" + 
			 		"      </div>\r\n" + 
			 		"      <!-- Grid row-->\r\n" + 
			 		"\r\n" + 
			 		"    </div>\r\n" + 
			 		"  </div>\r\n" + 
			 		"\r\n" + 
			 		"  <!-- Footer Links -->\r\n" + 
			 		"  <div class=\"container text-center text-md-left mt-5\">\r\n" +
			 		"\r\n" + 
			 		"    <!-- Grid row -->\r\n" + 
			 		"    <div class=\"row mt-3\">\r\n" + 
			 		"\r\n" + 
			 		"      <!-- Grid column -->\r\n" + 
			 		"      <div class=\"col-md-3 col-lg-4 col-xl-3 mx-auto mb-4\">\r\n" + 
			 		"\r\n" + 
			 		"        <!-- Content -->\r\n" + 
			 		"        <h6 class=\"text-uppercase font-weight-bold\" >GadgetBadget Company</h6>\r\n" + 
			 		"        <hr class=\"deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto\" style=\"width: 60px;\">\r\n" + 
			 		"        <p style=\"color:white\">Best funding company for young researchers....</p>\r\n" + 
			 		"\r\n" +
			 		"      </div>\r\n" + 
			 		"      <!-- Grid column -->\r\n" + 
			 		"\r\n" + 
			 		"      <!-- Grid column -->\r\n" + 
			 		"      <div class=\"col-md-2 col-lg-2 col-xl-2 mx-auto mb-4\">\r\n" + 
			 		"\r\n" + 
			 		"        <!-- Links -->\r\n" + 
			 		"        <h6 class=\"text-uppercase font-weight-bold\">Products</h6>\r\n" + 
			 		"        <hr class=\"deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto\" style=\"width: 60px;\">\r\n" + 
			 		"        <p>\r\n" + 
			 		"          <a href=\"#!\" style=\"color:white\">pen Drives</a>\r\n" + 
			 		"        </p>\r\n" + 
			 		"        <p>\r\n" + 
			 		"          <a href=\"#!\" style=\"color:white\">Hard Disks</a>\r\n" + 
			 		"        </p>\r\n" + 
			 		"        <p>\r\n" + 
			 		"          <a href=\"#!\" style=\"color:white\">T shirts</a>\r\n" + 
			 		"        </p>\r\n" + 
			 		"        <p>\r\n" + 
			 		"          <a href=\"#!\" style=\"color:white\">Cables</a>\r\n" + 
			 		"		</p>\r\n" + 
			 		"\r\n" +
			 		"      </div>\r\n" + 
			 		"      <!-- Grid column -->\r\n" + 
			 		"\r\n" +
			 		"      <!-- Grid column -->\r\n" + 
			 		"      <div class=\"col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4\">\r\n" + 
			 		"\r\n" + 
			 		"        <!-- Links -->\r\n" + 
			 		"        <h6 class=\"text-uppercase font-weight-bold\">Contact</h6>\r\n" +
			 		"        <hr class=\"deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto\" style=\"width: 60px;\">\r\n" + 
			 		"        <p style=\"color:white\">\r\n" +
			 		"          <i class=\"fa fa-home mr-3\"></i> Colombo, SriLanka</p>\r\n" + 
			 		"        <p style=\"color:white\">\r\n" + 
			 		"          <i class=\"fa fa-envelope mr-3\" style=\"color:white\"></i> info@example.com</p>\r\n" +
			 		"        <p style=\"color:white\">\r\n" + 
			 		"          <i class=\"fa fa-phone mr-3\" style=\"color:white\"></i> + 01 234 567 88</p>\r\n" +
			 		"        <p style=\"color:white\">\r\n" + 
			 		"          <i class=\"fa fa-print mr-3\" style=\"color:white\"></i> + 01 234 567 89</p>\r\n" + 
			 		"\r\n" + 
			 		"      </div>\r\n" + 
			 		"      <!-- Grid column -->\r\n" + 
			 		"\r\n" +
			 		"      </div>\r\n" + 
			 		"      <!-- Grid column -->\r\n" +
			 		"\r\n" +
			 		"  </div>\r\n" + 
			 		"  <!-- Footer Links -->\r\n" + 
			 		"\r\n" +
			 		"  <!-- Copyright -->\r\n" + 
			 		"  <div class=\"footer-copyright text-center py-3\" style=\"color:white\">© 2020 Copyright:\r\n" + 
			 		"    <a href=\"https://mdbootstrap.com/\" style=\"color:white\"> GadgetBadget Company</a>\r\n" + 
			 		"  </div>\r\n" + 
			 		"  <!-- Copyright -->\r\n" + 
			 		"\r\n" + 
			 		"</footer>\r\n" +
			 		"<!-- Footer -->\r\n" +
			 		"\r\n" +
			 		"\r\n" +
			 		"\r\n" +
			 		"<script>\r\n" + 
			 		"function myFunction() {\r\n" + 
			 		"  var x = document.getElementById(\"myTopnav\");\r\n" + 
			 		"  if (x.className === \"topnav\") {\r\n" +
			 		"    x.className += \" responsive\";\r\n" + 
			 		"  } else {\r\n" +
			 		"    x.className = \"topnav\";\r\n" + 
			 		"  }\r\n" +
			 		"}\r\n" + 
			 		"</script>\r\n" + 
			 		"\r\n" +
			 		"\r\n" +
			 		"\r\n" +
			 		" <!-- bootstrap -->\r\n" + 
			 		"	<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n" + 
			 		"	<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n" + 
			 		"	<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n" + 
			 		"<!-- bootstrap -->\r\n" + 
			 		"\r\n" + 
			 		"</body>\r\n"+
			 		"</html>";
			
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
