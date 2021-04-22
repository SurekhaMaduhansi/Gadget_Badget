package model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.DonationsService;
import model.Donations;

//import model.FundsAdmin;
//import com.FundsAdminService;

public class FundingDeskCus {
	
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
	
//-----------------------READ ALL PROJECTS---------------------------------------------------------------------//
	public String readProjects()
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
		output = "<html>\r\n" + 
				"<head>\r\n" + 
				"\r\n" + 
				"	<link rel=\"stylesheet\" href=\"../Home.css\">\r\n" + 
				"	<!-- bootstrap -->\r\n" + 
				"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"		\r\n" + 
				"	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" \r\n" + 
				"			integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n" + 
				"	\r\n" + 
				"	<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">	\r\n" + 
				"	\r\n" + 
				"	\r\n" + 
				"		\r\n" + 
				"	<!-- bootstrap -->\r\n" + 
				"<title>GadgetBadget</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"\r\n" +  
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
				"			  <a href=\"#\">Products</a>"
				+ 				"<a href=\"../../../GadgetBadget/FundingDeskCusService/FundingDeskCus/readMyProjects\">My Projects</a>"+ 
				"			  <a href=\"#\" class=\"active\">Funding HelpDesk</a>\r\n" + 
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
				"  <div id=\"carouselExampleIndicators\" class=\"carousel slide\" data-ride=\"carousel\">\r\n" + 
				"  <ol class=\"carousel-indicators\">\r\n" + 
				"    <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"0\" class=\"active\"></li>\r\n" + 
				"    <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"1\"></li>\r\n" + 
				"    <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"2\"></li>\r\n" + 
				"  </ol>\r\n" + 
				"  <div class=\"carousel-inner\">\r\n" + 
				"    <div class=\"carousel-item active\">\r\n" + 
				"      <img class=\"d-block w-100\" src=\"../images/cable.jpg\" alt=\"First slide\" height=\"500px\">\r\n" + 
				"    </div>\r\n" + 
				"    <div class=\"carousel-item\">\r\n" + 
				"      <img class=\"d-block w-100\" src=\"../images/hard.jpg\" alt=\"Second slide\" height=\"500px\">\r\n" + 
				"    </div>\r\n" + 
				"    <div class=\"carousel-item\">\r\n" + 
				"      <img class=\"d-block w-100\" src=\"../images/pen.jpg\" alt=\"Third slide\" height=\"500px\">\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"  <a class=\"carousel-control-prev\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"prev\">\r\n" + 
				"    <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\r\n" + 
				"    <span class=\"sr-only\">Previous</span>\r\n" + 
				"  </a>\r\n" + 
				"  <a class=\"carousel-control-next\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"next\">\r\n" + 
				"    <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\r\n" + 
				"    <span class=\"sr-only\">Next</span>\r\n" + 
				"  </a>\r\n" + 
				"</div>\r\n" + 
				"  <br><br><br>\r\n" + 
				"  \r\n" + 
				"  \r\n" + 
				"  <center><h3> Welcome to GadgetBadget </h3>\r\n" + 
				"  		<h2>Hope to donate and help young researchers ??</h2>"
				+ "<br><br>"
				+ " <button type=\"button\" class=\"btn btn-primary btn-lg\" data-toggle=\"modal\" data-target=\"#exampleModalCenter\">\r\n" + 
				"  		Donate->>\r\n" + 
				"	</button></center>\r\n" + 
				"	\r\n" + 
				"	<!-- Modal -->\r\n" + 
				"<div class=\"modal fade\" id=\"exampleModalCenter\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\r\n" + 
				"  <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\r\n" + 
				"    <div class=\"modal-content\">\r\n" + 
				"      <div class=\"modal-header\">\r\n" + 
				"        <h5 class=\"modal-title\" id=\"exampleModalLongTitle\">Fill Your details</h5>\r\n" + 
				"        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n" + 
				"          <span aria-hidden=\"true\">&times;</span>\r\n" + 
				"        </button>\r\n" + 
				"      </div>\r\n" + 
				"      <div class=\"modal-body\">\r\n" + 
				"        <form action=\"../../../GadgetBadget/DonationsService/Donations/InsertDonation\" method=\"post\">\r\n" + 
				"		  <div class=\"form-group row\">\r\n" + 
				"		    <label  class=\"col-sm-2 col-form-label\">Name</label>\r\n" + 
				"		    <div class=\"col-sm-10\">\r\n" + 
				"		      <input type=\"hidden\" name=\"donationID\">\r\n" + 
				"		      <input type=\"text\" class=\"form-control\"  placeholder=\"Enter your Name\" name=\"name\">\r\n" + 
				"		    </div>\r\n" + 
				"		  </div>\r\n" + 
				"		  <div class=\"form-group row\">\r\n" + 
				"		    <label for=\"inputEmail3\" class=\"col-sm-2 col-form-label\">Email</label>\r\n" + 
				"		    <div class=\"col-sm-10\">\r\n" + 
				"		      <input type=\"text\" class=\"form-control\"  placeholder=\"Enter your Email\" name=\"email\">\r\n" + 
				"		    </div>\r\n" + 
				"		  </div>\r\n" + 
				"		  <div class=\"form-group row\">\r\n" + 
				"		    <label class=\"col-sm-2 col-form-label\">Amount</label>\r\n" + 
				"		    <div class=\"col-sm-10\">\r\n" + 
				"		      <input type=\"text\" class=\"form-control\"  placeholder=\"Enter donating amount\" name=\"amount\">\r\n" + 
				"		    </div>\r\n" + 
				"		  </div>\r\n" + 
				"		  <div class=\"form-group row\">\r\n" + 
				"		    <label  class=\"col-sm-2 col-form-label\">Card Number</label>\r\n" + 
				"		    <div class=\"col-sm-10\">\r\n" + 
				"		      <input type=\"text\" class=\"form-control\"  placeholder=\"Enter your card number\" name=\"cardNumber\">\r\n" + 
				"		    </div>\r\n" + 
				"		  </div>\r\n" + 
				"		  <div class=\"form-group row\">\r\n" + 
				"		    <label  class=\"col-sm-2 col-form-label\">CVC</label>\r\n" + 
				"		    <div class=\"col-sm-10\">\r\n" + 
				"		      <input type=\"text\" class=\"form-control\"  placeholder=\"Enter your CVC\" name=\"CVC\">\r\n" + 
				"		    </div>\r\n" + 
				"		  </div>\r\n" + 
				"		  \r\n" + 
				"		  <input type=\"submit\" name=\"submit\" value=\"Donate\"  class=\"btn btn-primary\">\r\n" + 
				"		</form>\r\n" + 
				"      </div>\r\n" + 
				"      <div class=\"modal-footer\">\r\n" + 
				"        <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Cancel</button>\r\n" + 
				"      </div>\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"</div>"
				+ "<center><h5>--------------Current Projects--------------</h5><br><br>"
				+ "<div class=\"card mb-3\" style=\"width:900px\">";
		
		String query = "select * from projects";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		// iterate through the rows in the result set
		while (rs.next())
		{
			String ProjectID = Integer.toString(rs.getInt("ProjectID"));
			String ProjectCode = rs.getString("ProjectCode");
			String ProjectName = rs.getString("ProjectName");
			Blob Image = rs.getBlob("Image");
			String Description = rs.getString("Description");
			String Budget = rs.getString("Budget");
			String Category = rs.getString("Category");
			String UserEmail = rs.getString("UserEmail");
			
			
			// Add into the html table
			output += "<img class=\"card-img-top\" src="+Image+" alt=\"Card image cap\">";
			output += "<div class=\"card-body\">\r\n" + 
					"    <h5 class=\"card-title\">Project Name : "+ProjectName+"</h5>";
			output += "<h6>Budget : "+Budget+"</h6>\r\n" + 
					"    <p class=\"card-text\">About Project :  "+Description+"</p>";
			output += "<p class=\"card-text\"><small class=\"text-muted\"> Category : "+Category+"</small></p>\r\n" + 
					"    <p class=\"card-text\"><small class=\"text-muted\"> Reseacher Email : "+UserEmail+" </small></p>\r\n" + 
					"    <br><br>\r\n" + 
					"    <p>*******************************************************************************************************************************</p>\r\n" + 
					"    <p>*******************************************************************************************************************************</p>";
			
			// buttons
			output +="</div>"
					+ "</div>"
					+ "</center>" ;
		}
		
			con.close();
			// Complete the html table
			output += 
					"<footer class=\"page-footer font-small color-dark\" style=\"background-color:#1f3a93\">\r\n" + 
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
					"\r\n" + 
					"\r\n" + 
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
	
	
	
	//------------------------------------READ PROJECTS OF SPECIFIC USER--------------------------------------------------------------------------------//
		public String readMyProjects()
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
			output = "<html>\r\n" + 
					"<head>\r\n" + 
					"\r\n" + 
					"	<link rel=\"stylesheet\" href=\"../Home.css\">\r\n" + 
					"	<!-- bootstrap -->\r\n" + 
					"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"		\r\n" + 
					"	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" \r\n" + 
					"			integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n" + 
					"	\r\n" + 
					"	<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">	\r\n" + 
					"	\r\n" + 
					"	\r\n" + 
					"		\r\n" + 
					"	<!-- bootstrap -->\r\n" + 
					"<title>GadgetBadget</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"\r\n" + 
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
					"			  <a href=\"#\" class=\"active\">Projects</a>\r\n" + 
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
					"  <div id=\"carouselExampleIndicators\" class=\"carousel slide\" data-ride=\"carousel\">\r\n" + 
					"  <ol class=\"carousel-indicators\">\r\n" + 
					"    <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"0\" class=\"active\"></li>\r\n" + 
					"    <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"1\"></li>\r\n" + 
					"    <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"2\"></li>\r\n" + 
					"  </ol>\r\n" + 
					"  <div class=\"carousel-inner\">\r\n" + 
					"    <div class=\"carousel-item active\">\r\n" + 
					"      <img class=\"d-block w-100\" src=\"../images/cable.jpg\" alt=\"First slide\" height=\"500px\">\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"carousel-item\">\r\n" + 
					"      <img class=\"d-block w-100\" src=\"../images/hard.jpg\" alt=\"Second slide\" height=\"500px\">\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"carousel-item\">\r\n" + 
					"      <img class=\"d-block w-100\" src=\"../images/cable.jpg\\\" alt=\"Third slide\" height=\"500px\">\r\n" + 
					"    </div>\r\n" + 
					"  </div>\r\n" + 
					"  <a class=\"carousel-control-prev\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"prev\">\r\n" + 
					"    <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\r\n" + 
					"    <span class=\"sr-only\">Previous</span>\r\n" + 
					"  </a>\r\n" + 
					"  <a class=\"carousel-control-next\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"next\">\r\n" + 
					"    <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\r\n" + 
					"    <span class=\"sr-only\">Next</span>\r\n" + 
					"  </a>" + 
					"</div>" + 
					"  <br><br><br>" + 
					"  \r\n" +  
					"  <center><h3> Welcome to GadgetBadget </h3></center>\r\n" + 
					" <br>\r\n" + 
					"<center><h5>projects you have submitted will be appeared here</h5>\r\n" + 
					"<br>" + 
					"<table class=\"table\" >\r\n" + 
					"  <thead class=\"thead-dark\">\r\n" + 
					"    <tr>\r\n" + 
					"      <th scope=\"col\">id</th>\r\n" + 
					"      <th scope=\"col\">Project Code</th>\r\n" + 
					"      <th scope=\"col\">Project Name</th>\r\n" + 
					"      <th scope=\"col\">Description</th>\r\n" + 
					"      <th scope=\"col\">Budget</th>\r\n" + 
					"      <th scope=\"col\">Category</th>\r\n" + 
					"      <th scope=\"col\">User Email</th>\r\n" + 
					"      <th scope=\"col\"></th>\r\n" + 
					"      <th scope=\"col\"></th>\r\n" + 
					"      <th scope=\"col\"></th>\r\n" + 
					"    </tr></thead>";
			
			String query = "select * from projects where UserEmail like 'surekha@GB.com'";//------ hard coded---
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
		
			// iterate through the rows in the result set
			while (rs.next())
			{
				String ProjectID = Integer.toString(rs.getInt("ProjectID"));
				String ProjectCode = rs.getString("ProjectCode");
				String ProjectName = rs.getString("ProjectName");
				Blob Image = rs.getBlob("Image");
				String Description = rs.getString("Description");
				String Budget = rs.getString("Budget");
				String Category = rs.getString("Category");
				String UserEmail = rs.getString("UserEmail");
				int status = rs.getInt("status");
				
				// Add into the html table
				output += "<tbody>\r\n" + 
						"    <tr>"
						+ "<td>" + ProjectID + "</td>";
				output += "<td>" + ProjectCode + "</td>";
				output += "<td>" + ProjectName + "</td>";
				output += "<td>" + Description + "</td>";
				output += "<td>" + Budget + "</td>";
				output += "<td>" + Category + "</td>";
				output += "<td>" + UserEmail + "</td>";
				
				if(status==0) {
					
					output +=  "<td>"+
							"        <form action='../../../GadgetBadget/FundingDeskCusService/FundingDeskCus/insertFundRequests' method=\"post\">" + 
							"		    <label>Bank Card Number</label>" + 
							"			  <input type='hidden' name='UserEmail' value='"+UserEmail+"' >\r\n" + 
							"				<input type='hidden' name='ProjectID' value='"+ProjectID+"' >\r\n" + 
							"		      <input type=\"text\" class=\"form-control\"  placeholder=\"Enter card number\" name=\"BankCardNumber\">\r\n" +  
							"		  <input type=\"submit\" name=\"submit\" value=\"Send request\"  class=\"btn btn-primary\">\r\n" + 
							"		</form>\r\n" + "</td>";
							
				}else if(status == 1) {
					
					output +=  "<td><div class='badge badge-warning'> Requested for funds </div></td>";
							
				}else if(status == 2) {
					output +=  "<td><div class='badge badge-success'> Request Accepted </div></td>";
				}
				
				output +=  "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-primary'></td>"
						+ "<td><input name='btnDelete' type='button' value='Delete' class='btn btn-danger'></td>";
				
				// buttons
				
			}
			
				con.close();
				// Complete the html table
				output += "</tr></table>"
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
						"\r\n" + 
						"\r\n" + 
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
		
	
	
	
	
	

}
