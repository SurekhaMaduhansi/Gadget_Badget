package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.FundingDeskCus;
import com.FundsAdminService;

import model.Donations;
import com.DonationsService;

public class FundsAdmin {
	
	private Connection connect()
	 {
		Connection con = null;
		 try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
	
		 //Provide the correct details: DBServer/DBName, username, password
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gadgetbudget?useTimezone=true&serverTimezone=UTC", "root", "");
		 }catch (Exception e){
			 e.printStackTrace();
			 }
		
		 return con;
	} 
	
	
	public String readFundRequests()
	{
		String output = "";
		try
		{
	
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for reading."; 
			}
			
		// Prepare the html table to be displayed
		output = 
				 "<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"\r\n" + 
				"	<link rel=\"stylesheet\" href=\"../../../GadgetBadget/Home.css\">\r\n" + 
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
				"     			 <img src=\"../images/Capture.PNG\" alt=\"logo\" width=\"220\" height=\"60\" float=\"left\">\r\n" + 
				"   			</a>\r\n" + 
				"   			<br>\r\n" + 
				"   			<div class=\"topnav\" id=\"myTopnav\">\r\n" + 
				"			  <a href=\"../../../GadgetBadget/HomesService/Homes/AdminHome\" >Home</a>\r\n" + 
				"			  <a href=\"#\">Products</a>\r\n" + 
				"			  <a href=\"../../../GadgetBadget/DonationsService/Donations\">Donations</a>\r\n" + 
				"			  <a href=\"\" class=\"active\">Funding HelpDesk</a>\r\n" + 
				"			  <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\">\r\n" + 
				"			    <i class=\"fa fa-bars\"></i>\r\n" + 
				"			  </a>\r\n" + 
				"			\r\n" + 
				"			</div>\r\n" + 
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
				"  <img class=\"card-img-top\" src=\"../images/adminpage.jpg\" alt=\"Card image cap\"  height=\"500px\"><br><br>"
				+ "<form action='../../../GadgetBadget/FundsAdminService/FundsAdmin/readAcceptedFunds' method='get'>"
				+ "<input name='btnView' type='submit' class='btn btn-info' value='View Accepted Funds'><br><br>"
				+ "</form>"
				+ "<center><table class=\"table\" style='width:1300px'><thead class=\"thead-dark\" style='width:600'>"
				+ "<tr>"
					+ "<th scope=\"col\">Request ID</th>"
					+ "	<th scope=\"col\">Project ID</th>"
					+ "<th scope=\"col\">Project Name</th>" 
					+"<th scope=\"col\">Description</th>" 
					+"<th scope=\"col\">Budget</th>" 
					+"<th scope=\"col\">User Email</th>" 
					+"<th scope=\"col\">Bank Card</th>" 
					+"<th scope=\"col\"></th>"
					+ "<th scope=\"col\"></th></tr>"
					+ "</thead>";
		
		String query = "select P.ProjectName, P.ProjectID, P.Description,P.Budget, P.UserEmail,F.RequestID,F.BankCardNumber"
				+ " from fundrequests F, projects P "
				+ "where F.ProjectID=P.ProjectID ";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		// iterate through the rows in the result set
		while (rs.next())
		{
			String RequestID = Integer.toString(rs.getInt("RequestID"));
			String ProjectID = Integer.toString(rs.getInt("ProjectID"));
			String ProjectName = rs.getString("ProjectName");
			String Description = rs.getString("Description");
			String Budget = rs.getString("Budget");
			String UserEmail = rs.getString("UserEmail");
			String BankCardNumber= rs.getString("BankCardNumber");
			// Add into the html table
			output += "<tbody>"
					+ "<tr>"
					+ "<td>" + RequestID + "</td>"
					+ "<td>" + ProjectID + "</td>";
			output += "<td>" + ProjectName + "</td>";
			output += "<td>" + Description + "</td>";
			output += "<td>" + Budget + "</td>";
			output += "<td>" + UserEmail + "</td>";
			output += "<td>" + BankCardNumber + "</td>";
			
			// buttons
			output += "<td><form method='post' action='../../../GadgetBadget/FundsAdminService/FundsAdmin/accept'><input name='btnAccept' type='submit' value='Accept Request' class='btn btn-success' id='myButton' onclick='change()'>"
					+ "<input name='RequestID' type='hidden' value='" + RequestID+ "'>"
							+ "<input name='ProjectID' type='text' value='"+ProjectID+"' hidden>"
							+ "<input name='UserEmail' type='text' value='"+UserEmail+"' hidden><br><br>"
							+ "<input type='hidden' class='form-control'  name='Budget' value='"+Budget+"'  readonly>"
							+ "<label>Funding amount :</label><br>"
							+ "<input type='text' name='amount' class='form-control' placeholder='Enter funding amount' required>"
					+ "</form></td>"
			+ "<td><form method='post' action='../../../GadgetBadget/FundsAdminService/FundsAdmin/DeleteFundRequests'>"
					+ "<input name='btnRemove' type='submit' value='Reject' class='btn btn-danger'>"
					+ "<input name='RequestID' type='hidden' value='" + RequestID+ "'>"
					+ "<input name='ProjectID' type='hidden' value='"+ProjectID+"'>" 
				+ "</form>"
			+ "</td></tr>"
			+ "</tbody>";
		}
		
			con.close();
			// Complete the html table
			output += "</table></center><br><br>"
					+ "<footer class=\"page-footer font-small color-dark\" style=\"background-color:#1f3a93\">\r\n" + 
					"\r\n" + 
					"  <div style=\"background-color: #59abe3;\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"\r\n" + 
					"      <!-- Grid row-->\r\n" + 
					"      <div class=\"row py-4 d-flex align-items-center\">\r\n" + 
					"\r\n" + 
					"        <!-- Grid column -->\r\n" + 
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
					"        </p>\r\n" + 
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
					"    </div>\r\n" + 
					"    <!-- Grid row -->\r\n" + 
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
					"<!-- Footer -->\r\n"  + 
					"<script>\r\n" + 
					"function myFunction() {\r\n" + 
					"  var x = document.getElementById(\"myTopnav\");\r\n" + 
					"  if (x.className === \"topnav\") {\r\n" + 
					"    x.className += \" responsive\";\r\n" + 
					"  } else {\r\n" + 
					"    x.className = \"topnav\";\r\n" + 
					"  }\r\n" + 
					"}\r\n" + 
					"</script>"
					+ "<script>"
					+ "function change();\r\n" + 
					"{\r\n" + 
					"    document.getElementById(\"myButton\").value=\"Accepted\";\r\n" + 
					"}"
					+ "</script>" + 
					  
					" <!-- bootstrap -->\r\n" + 
					"	<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n" + 
					"	<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n" + 
					"	<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n" + 
					"<!-- bootstrap -->\r\n" + 
					"\r\n" + 
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
	
	
	
	
	public String deleteFundRequests(String RequestID, int ProjectID)
	 {
		 String output = "";
			 try
			 {
				 Connection con = connect();
				 if (con == null)
				 {
					 return "Error while connecting to the database for deleting.";
				 }
				 // create a prepared statement
				 String query = "delete from fundrequests where RequestID=?";
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 
				 // binding values
				 preparedStmt.setInt(1, Integer.parseInt(RequestID));
				 // execute the statement
				 preparedStmt.execute();
				 
				 
				 String query1 = "UPDATE projects SET status=3 WHERE ProjectId = '"+ProjectID+"'";
				 PreparedStatement preparedStmt1 = con.prepareStatement(query1);
				 
				 preparedStmt1.execute();
				 
				 
				 con.close();
				 output = "Rejected";
				 
			 }
			 catch (Exception e)
			 {
				 output = "Error while transferring the donation.";
				 System.err.println(e.getMessage());
			 }
		 return output;
	 } 
	
	
	
	
	public String insertAcceptedFunds(String UserEmail, int ProjectID, String amount,String RequestID){
		
		 String output = "";
		 
		 
		 
		 try{
			 Connection con = connect();
			 if (con == null)
			 {
				 return "Error while connecting to the database for inserting.";
			 }
			  
			
			 // create a prepared statement
			 String query = " insert into accepted(`FundID`,`UserEmail`,`ProjectID`,`amount`)"+ " values (?, ?, ?, ?)";
			
			 
			 PreparedStatement preparedStmt = con.prepareStatement(query);
		
			 
			 // binding values
			 preparedStmt.setInt(1, 0);
			 preparedStmt.setString(2, UserEmail);
			 preparedStmt.setInt(3, ProjectID);
			 preparedStmt.setString(4, amount);
			
			// execute the statement
			
			 preparedStmt.execute();
			 
			 deleteFundRequests(RequestID,ProjectID);
			 
			 String query1 = "UPDATE projects SET status=2 WHERE ProjectId = '"+ProjectID+"'";
			 PreparedStatement preparedStmt1 = con.prepareStatement(query1);
			 
			 preparedStmt1.execute();
			 
			 con.close();
			 output = "Funding is successful";
		 }
		 catch (Exception e)
		 {
			 output = "Already accepted the fund.";
			 System.err.println(e.getMessage());
		 }
		 
		 return output;
	 }
	
	
	
	public String readAcceptedFunds()
	{
		String output = "";
		try
		{
	
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for reading."; 
			}
			
		
		output = "<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"\r\n" + 
				"	<link rel=\"stylesheet\" href=\"../../../GadgetBadget/Home.css\">\r\n" + 
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
				"     			 <img src=\"../../../GadgetBadget/images/Capture.PNG\" alt=\"logo\" width=\"220\" height=\"78\" float=\"left\">\r\n" + 
				"   			</a>\r\n" + 
				"   			<br>\r\n" + 
				"   			<div class=\"topnav\" id=\"myTopnav\">\r\n" + 
				"			  <a href=\"../../../GadgetBadget/HomesService/Homes/AdminHome\" >Home</a>\r\n" + 
				"			  <a href=\"#\">Products</a>\r\n" + 
				"			  <a href=\"../../../GadgetBadget/DonationsService/Donations\" >Donations</a>\r\n" + 
				"			  <a href=\"../../../GadgetBadget/FundsAdminService/FundsAdmin\" class=\"active\">Funding HelpDesk</a>\r\n" + 
				"			  <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\">\r\n" + 
				"			    <i class=\"fa fa-bars\"></i>\r\n" + 
				"			  </a>\r\n" + 
				"			\r\n" + 
				"			</div>\r\n" + 
				"			\r\n" +  
				"      \r\n" + 
				"			<div class=\"dropdown\">\r\n" + 
				"			   <img src=\"../../../GadgetBadget/images/avatar.png\" class=\"img-fluid\" alt=\"avatar1\" width=\"50\" height=\"80\" >\r\n" + 
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
				"  <img class=\"card-img-top\" src=\"../../../GadgetBadget/images/adminpage.jpg\" alt=\"Card image cap\"  height=\"500px\">\r\n" + 
				"  <br><br><br>"
				+ "<br><br>"
				+ "<center><table class=\"table\" style='width:850px'><thead><tr><th>Fund ID</th>" +
		"<th scope=\"col\">Project Name</th>" +
		"<th scope=\"col\">Reseacher Email</th>" +
		"<th scope=\"col\">Funded amount</th>" +
		"<th scope=\"col\">Description</th></tr><thead>";
		
		String query = "select A.FundID,A.amount,A.UserEmail,P.ProjectName,P.Description from accepted A, projects P where A.ProjectID=P.ProjectId ";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		// iterate through the rows in the result set
		while (rs.next())
		{
			String FundID = Integer.toString(rs.getInt("FundID"));
			String ProjectName = rs.getString("ProjectName");
			String UserEmail = rs.getString("UserEmail");
			String amount = rs.getString("amount");
			String Description = rs.getString("Description");
			
			
			// Add into the html table
			output += "<tbody><tr><td>" + FundID + "</td>";
			output += "<td>" + ProjectName + "</td>";
			output += "<td>" + UserEmail + "</td>";
			output += "<td>" + amount + "</td>";
			output += "<td>" + Description + "</td>";
			
			// buttons
			output += "<td>"
						+ "<form action='../../../GadgetBadget///' method='post'>"
						+ "<input name='btnUpdate' type='submit' value='Update' class='btn btn-info'>"
						+ "<input name='FundID' type='hidden' value='" + FundID+ "'>"
						+ "</form>"
					+ "</td></tr></tbody>";
		}
		
			con.close();
			// Complete the html table
			output += "</table><center><br><br>"
					+ "<footer class=\"page-footer font-small color-dark\" style=\"background-color:#1f3a93\">\r\n" + 
					"\r\n" + 
					"  <div style=\"background-color: #59abe3;\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"\r\n" + 
					"      <!-- Grid row-->\r\n" + 
					"      <div class=\"row py-4 d-flex align-items-center\">\r\n" + 
					"\r\n" + 
					"        <!-- Grid column -->\r\n" + 
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
					"        </p>\r\n" + 
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
					"    </div>\r\n" + 
					"    <!-- Grid row -->\r\n" + 
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
					"</body>\r\n" + 
					"</html>";
		}
		catch (Exception e)
		{
			output = "Error while loading the accepted request list.";
			System.err.println(e.getMessage());
		}
		
		
		return output;
		
	} 	
	
	
	public String updateFund(String FundID,String UserEmail,String ProjectID, String amount)
	{
		String output = "";
		 try
		 {
			 Connection con = connect();
			 
			 if (con == null)
			 {return "Error while connecting to the database for updating."; }
			 
			 // create a prepared statement
			 String query = "UPDATE accepted SET UserEmail=?,ProjectID=?,amount=? WHERE FundID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 
			 preparedStmt.setString(1, UserEmail);
			 preparedStmt.setInt(2,Integer.parseInt(ProjectID));
			 preparedStmt.setString(3, amount);
			 preparedStmt.setInt(4,Integer.parseInt(FundID));
			
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Updated successfully";
		 }
		 catch (Exception e)
		 {
			 output = "Error while updating the item.";
			 System.err.println(e.getMessage());
		 }
		 return output;
	}
	
	
	
	
	

}
