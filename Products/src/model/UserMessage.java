
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Products;
import com.UserMessageService;
public class UserMessage {
	
	private Connection connect()
	 {
		 Connection con = null;
		 try
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagement?useTimezone=true&serverTimezone=UTC", "root", "");


		 }
		 catch (Exception e)
		 {		System.out.println("Database connection is not success!!!");
		 }
		 return con;
	 }

	public String insertMessage(String ID,String email,String subject, String body )
	 {
		 String output = "";
			 try
			 {
			 Connection con = connect();
				 if (con == null)
				 {
					 return "Error while connecting to the database for inserting."; 
				 }
			
			
			 
				 // create a prepared statement
				 String query = " insert into message(`ID`,`email`,`subject`,`body`)"
						 + " values (?, ?, ?, ?)";
				 
						 PreparedStatement preparedStmt = con.prepareStatement(query);
						
						 // binding values
						 preparedStmt.setInt(1, 0);
						 preparedStmt.setString(2, email);
						 preparedStmt.setString(3, subject);
						 preparedStmt.setString(4, body);
						 
						 // execute the statement
						 preparedStmt.execute();
						 con.close();
						 output = "Send successfully";
				 }
			 
			 
				  catch (Exception e)
				 {
						 output = "Error while Sending the message.";
						 System.err.println(e.getMessage());
				 }
						
			     return output;
			 }
	
	
	
	
	public String readMsg()
	 {
		
		 String output = "";
		
		 try
		 {
			Connection con = connect();
			
			if (con == null) 
			{return "Error while connecting to the database for reading."; }
			
			output ="<html>\r\n" + 
					"<head>\r\n" + 
					"<link rel=\"stylesheet\" href=\"../css/userHome.css\">\r\n" + 
					"<link rel=\"stylesheet\" href=\"../css/messageUs.css\">\r\n" + 
					"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
					"<script src='https://kit.fontawesome.com/a076d05399.js'></script>\r\n" + 
					"					<link rel=\"stylesheet\" href=\"Home.css\">\r\n" + 
					"					<!-- bootstrap --> \r\n" + 
					"					 <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \r\n" + 
					"					\r\n" + 
					"					 <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"  \r\n" + 
					"					 integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\"> \r\n" + 
					"					\r\n" + 
					"					 <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\"\r\n" + 
					"					 <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
					"					 <script src='https://kit.fontawesome.com/a076d05399.js'></script> \r\n" + 
					"					 </head>\r\n" + 
					"					 <title>GadgetBadget</title> \r\n" + 
					"					 		</head> \r\n" + 
					"					 		\r\n" + 
					"					 		<body> \r\n" + 
					"					 		 \r\n" + 
					"					 		  <nav  class=\"navbar fixed-top navbar-white bg-white\"> \r\n" + 
					"					 				<div class= \"container\">\r\n" + 
					"					 					<a class=\"navbar-brand\" href=\"#\"> \r\n" + 
					"					 		   			 <img src=\"../images/Capture.png\" alt=\"logo\" width=\"220\" height=\"95\" float=\"left\">\r\n" + 
					"					 		 			</a> \r\n" + 
					"					 		   			<br>\r\n" + 
					"					 		   			<div class=\"topnav\" id=\"myTopnav\">\r\n" + 
					"					 					  <a href=\"#\" class=\"active\">Home</a>  \r\n" + 
					"					 					  <a href=\"#\">Products</a>  \r\n" + 
					"					 					  <a href=\"#\">Projects</a> \r\n" + 
					"					 					  <a href=\"#\">Funding HelpDesk</a>\r\n" + 
					"					 					  <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\"> \r\n" + 
					"					 					    <i class=\"fa fa-bars\"></i> \r\n" + 
					"					 					  </a> \r\n" + 
					"					 					</div>\r\n" + 
					"					 					<button class=\"btn\"><i class=\"fa fa-shopping-cart\" style=\"font-size:24px\"></i></button> \r\n" + 
					"					 		\r\n" + 
					"					 					<div class=\"dropdown\">\r\n" + 
					"					 				   <img src=\"../images/avatar.png\" class=\"img-fluid\" alt=\"avatar1\" width=\"50\" height=\"78\" >\r\n" + 
					"					 				  <div class=\"dropdown-content\"> \r\n" + 
					"					 					    <a href=\"#\">Sign Up</a> \r\n" + 
					"					 					    <a href=\"#\">Log In</a> \r\n" + 
					"					 					  </div> \r\n" + 
					"					 					</div>  \r\n" + 
					"					 					\r\n" + 
					"					 				</div>  \r\n" + 
					"					 			  \r\n" + 
					"					 			</nav> \r\n" + 
					"					 			 \r\n" + 
					"					 			<br> \r\n" + 
					"					 		  <br><br> \r\n" + 
					"					 		"+
					"</head>\r\n" + 
					"    <!--Header-->\r\n" + 
					"    <br><br><br>\r\n" + 
					"    <div class=\"topnav sticky\">\r\n" + 
					
					"    \r\n" + 
					"          \r\n" + 
					"           <b> <h2><a href=\"\">sa@gmail.com <i class='fas fa-user-alt'></i></a></h2>\r\n" + 
					
					"            <a href=\"../../../Products/UserHomeService/AllProducts\">Home<i class=\"fa fa-institution\"></i></a>\r\n" + 
					"            <a href=\"../../../Products/MyCartService/viewMyCart\">My Cart<i class='fas fa-cart-arrow-down'></i></a>\r\n" + 
					"            <a href=\"../../../Products/UserViewProductService/UserCart\">My Orders  <i class='fab fa-elementor'></i></a>\r\n" + 
					"            <a href=\"../../../Products/UserMessageService/messageUser\">Message Us <i class='fas fa-comment-alt'></i></a>\r\n" + 
					"     \r\n" + 
				
					"            <div class=\"search-container\">\r\n" + 
					"                <form action=\"searchHome.jsp\" method=\"post\">\r\n" + 
					"					    	<input type = \"text\" placeholder=\"Search Item\" name= \"search\">\r\n" + 
					"					    	<button type = \"Submit\"><i class=\"fa fa-search\"></i>\r\n" + 
					"					    	 Search</button>\r\n" + 
					"					    \r\n" + 
					"					    </form>\r\n" + 
					"               \r\n" + 
					"             \r\n" + 
					"            </div>\r\n" + 
					"          </div>\r\n" + 
					"           <br>\r\n" + 
					
					"           <!--table-->\r\n" + 
					"<div style=\"color: black; text-align: center; font-size: 22px;\">Message Us <i class='fas fa-comment-alt'></i></div>"+
					"<br><center>	<div class=\"myDiv\"><br><br><form action='../../../Products/UserMessageService/messageUser/AddMessage' method=\"post\">\r\n" +
					"               <input type='hidden' name='email' value='sa@gmail.com'>"+//hardcoded
					"				<input class=\"input-style\" name=\"subject\" type =\"text\" placeholder=\"subject....\" required>\r\n" + 
					"				<hr>\r\n" + 
					"				<textarea class=\"input-style\" name=\"body\" type =\"text\" placeholder=\"Enter Your Message....\" required></textarea>\r\n" + 
					"				<hr>\r\n" + 
					"				<button type=\"submit\" class=\"button button2\">Send</button>\r\n </form></div>" ;
			 // Complete the html table
		 	output += "</table><br><br><footer class=\"page-footer font-small color-dark\" style=\"background-color:#1f3a93\">\r\n" + 
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
			 output = "Error while reading the items.";
			 System.err.println(e.getMessage());
		}
		
		return output;
		}
	
	public String AdminReadMsg()
	 {
		
		 String output = "";
		
		 try
		 {
			Connection con = connect();
			
			if (con == null) 
			{return "Error while connecting to the database for reading."; }
		
			output ="<html>\r\n" + 
			 		"<head>\r\n" + 
			 		"<link rel=\"stylesheet\" href=\"../css/homee-style.css\">\r\n" + 
			 		"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
			 		"<script src='https://kit.fontawesome.com/a076d05399.js'></script>\r\n" + 
			 		"					<link rel=\"stylesheet\" href=\"Home.css\">\r\n" + 
			 		"					<!-- bootstrap --> \r\n" + 
			 		"					 <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \r\n" + 
			 		"					\r\n" + 
			 		"					 <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"  \r\n" + 
			 		"					 integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\"> \r\n" + 
			 		"					\r\n" + 
			 		"					 <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\"\r\n" + 
			 		"					 <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
			 		"					 <script src='https://kit.fontawesome.com/a076d05399.js'></script> \r\n" + 
			 		"					 </head>\r\n" + 
			 		"					 <title>GadgetBadget</title> \r\n" + 
			 		"					 		</head> \r\n" + 
			 		"					 		\r\n" + 
			 		"					 		<body> \r\n" + 
			 		"					 		 \r\n" + 
			 		"					 		  <nav  class=\"navbar fixed-top navbar-white bg-white\"> \r\n" + 
			 		"					 				<div class= \"container\">\r\n" + 
			 		"					 					<a class=\"navbar-brand\" href=\"#\"> \r\n" + 
			 		"					 		   			 <img src=\"../images/Capture.png\" alt=\"logo\" width=\"220\" height=\"95\" float=\"left\">\r\n" + 
			 		"					 		 			</a> \r\n" + 
			 		"					 		   			<br>\r\n" + 
			 		"					 		   			<div class=\"topnav\" id=\"myTopnav\">\r\n" + 
			 		"					 					  <a href=\"#\" class=\"active\">Home</a>  \r\n" + 
			 		"					 					  <a href=\"#\">Products</a>  \r\n" + 
			 		"					 					  <a href=\"#\">Projects</a> \r\n" + 
			 		"					 					  <a href=\"#\">Funding HelpDesk</a>\r\n" + 
			 		"					 					  <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\"> \r\n" + 
			 		"					 					    <i class=\"fa fa-bars\"></i> \r\n" + 
			 		"					 					  </a> \r\n" + 
			 		"					 					</div>\r\n" + 
			 		"					 					<button class=\"btn\"><i class=\"fa fa-shopping-cart\" style=\"font-size:24px\"></i></button> \r\n" + 
			 		"					 		\r\n" + 
			 		"					 					<div class=\"dropdown\">\r\n" + 
			 		"					 				   <img src=\"../images/avatar.png\" class=\"img-fluid\" alt=\"avatar1\" width=\"50\" height=\"78\" >\r\n" + 
			 		"					 				  <div class=\"dropdown-content\"> \r\n" + 
			 		"					 					    <a href=\"#\">Sign Up</a> \r\n" + 
			 		"					 					    <a href=\"#\">Log In</a> \r\n" + 
			 		"					 					  </div> \r\n" + 
			 		"					 					</div>  \r\n" + 
			 		"					 					\r\n" + 
			 		"					 				</div>  \r\n" + 
			 		"					 			  \r\n" + 
			 		"					 			</nav> \r\n" + 
			 		"					 			 \r\n" + 
			 		"					 			<br> \r\n" + 
			 		"					 		  <br><br> \r\n" + 
			 		"					 		"+
			 		"</head>\r\n" + 
			 		"    <!--Header-->\r\n" + 
			 		"    <br>\r\n" + 
			 		"    <div class=\"topnav sticky\">\r\n" + 
			 		"    \r\n" + 
			 		"         \r\n" + 
			 		"           <br> <center></center>\r\n" + 
			 		"            <li><a href=\"../../../Products/addProductService/addProduct\">Add New Product <i class='fas fa-plus-square'></i></a></li>\r\n" + 
			 		"            <li><a href=\"../../../Products/ProductsService/Products\">All Products & Edit Products <i class='fab fa-elementor'></i></a>\r\n" + 
			 		"            <li><a href=\"../../../Products/AdminMessageViewService/MessageView\">Messages Received <i class='fas fa-comment-alt'></i></a></li>\r\n" + 
			 		"            <li><a href=\"../../../Products/AdminCheckService/checkbill\">Orders Received <i class=\"fas fa-archive\"></i></a></li>\r\n" + 
			 		"            <li><a href=\"../../../Products/CanceledOrdersViewService/CanceledView\">Cancel Orders <i class='fas fa-window-close'></i></a></li>\r\n" + 
			 		"            <li><a href=\"../../../Products/DeliveredOrdersViewService/DeliveredView\">Delivered Orders <i class='fas fa-dolly'></i></a></li>\r\n" + 
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
			 		"	\r\n " +  
			 		"<div style=\"color: black; text-align: center; font-size: 22px;\">Message Received <i class='fas fa-comment-alt'></i></div>"+
					"<br><center><table border='1' id=\"pr\"><tr><th>ID</th>" +
				    "<th>Email Of The Sender</th>" +
				    "<th>Subject</th>" +
				    "<th>Message</th>" ;
				  
			 String query = "select * from message";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 
			 // iterate through the rows in the result set
				
			 while (rs.next())
			 {
				 String ID = Integer.toString(rs.getInt("ID"));
				 String email = rs.getString("email");
				 String subject = rs.getString("subject");
				 String body = rs.getString("body");
			
		
				 // Add into the html table
				 output += "<tr><td>" + ID + "</td>";
				 output += "<td>" + email + "</td>";
				 output += "<td>" + subject + "</td>";
				 output += "<td>" + body + "</td>";
			
			
				 }
				 con.close();
				 
				 // Complete the html table
					output += "</table></center><br><br><footer class=\"page-footer font-small color-dark\" style=\"background-color:#1f3a93\">\r\n" + 
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
			 output = "Error while reading the items.";
			 System.err.println(e.getMessage());
		}
		
		return output;
		}
	
	
	public String AdminReadDeliveredOr()
	 {
		
		 String output = "";
		
		 try
		 {
			Connection con = connect();
			
			if (con == null) 
			{return "Error while connecting to the database for reading."; }
			
			output ="<html>\r\n" + 
			 		"<head>\r\n" + 
			 		"<link rel=\"stylesheet\" href=\"../css/homee-style.css\">\r\n" + 
			 		"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
			 		"<script src='https://kit.fontawesome.com/a076d05399.js'></script>\r\n" + 
			 		"					<link rel=\"stylesheet\" href=\"Home.css\">\r\n" + 
			 		"					<!-- bootstrap --> \r\n" + 
			 		"					 <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \r\n" + 
			 		"					\r\n" + 
			 		"					 <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"  \r\n" + 
			 		"					 integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\"> \r\n" + 
			 		"					\r\n" + 
			 		"					 <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\"\r\n" + 
			 		"					 <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
			 		"					 <script src='https://kit.fontawesome.com/a076d05399.js'></script> \r\n" + 
			 		"					 </head>\r\n" + 
			 		"					 <title>GadgetBadget</title> \r\n" + 
			 		"					 		</head> \r\n" + 
			 		"					 		\r\n" + 
			 		"					 		<body> \r\n" + 
			 		"					 		 \r\n" + 
			 		"					 		  <nav  class=\"navbar fixed-top navbar-white bg-white\"> \r\n" + 
			 		"					 				<div class= \"container\">\r\n" + 
			 		"					 					<a class=\"navbar-brand\" href=\"#\"> \r\n" + 
			 		"					 		   			 <img src=\"../images/Capture.png\" alt=\"logo\" width=\"220\" height=\"95\" float=\"left\">\r\n" + 
			 		"					 		 			</a> \r\n" + 
			 		"					 		   			<br>\r\n" + 
			 		"					 		   			<div class=\"topnav\" id=\"myTopnav\">\r\n" + 
			 		"					 					  <a href=\"#\" class=\"active\">Home</a>  \r\n" + 
			 		"					 					  <a href=\"#\">Products</a>  \r\n" + 
			 		"					 					  <a href=\"#\">Projects</a> \r\n" + 
			 		"					 					  <a href=\"#\">Funding HelpDesk</a>\r\n" + 
			 		"					 					  <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\"> \r\n" + 
			 		"					 					    <i class=\"fa fa-bars\"></i> \r\n" + 
			 		"					 					  </a> \r\n" + 
			 		"					 					</div>\r\n" + 
			 		"					 					<button class=\"btn\"><i class=\"fa fa-shopping-cart\" style=\"font-size:24px\"></i></button> \r\n" + 
			 		"					 		\r\n" + 
			 		"					 					<div class=\"dropdown\">\r\n" + 
			 		"					 				   <img src=\"../images/avatar.png\" class=\"img-fluid\" alt=\"avatar1\" width=\"50\" height=\"78\" >\r\n" + 
			 		"					 				  <div class=\"dropdown-content\"> \r\n" + 
			 		"					 					    <a href=\"#\">Sign Up</a> \r\n" + 
			 		"					 					    <a href=\"#\">Log In</a> \r\n" + 
			 		"					 					  </div> \r\n" + 
			 		"					 					</div>  \r\n" + 
			 		"					 					\r\n" + 
			 		"					 				</div>  \r\n" + 
			 		"					 			  \r\n" + 
			 		"					 			</nav> \r\n" + 
			 		"					 			 \r\n" + 
			 		"					 			<br> \r\n" + 
			 		"					 		  <br><br> \r\n" + 
			 		"					 		"+
			 		"</head>\r\n" + 
			 		"    <!--Header-->\r\n" + 
			 		"    <br>\r\n" + 
			 		"    <div class=\"topnav sticky\">\r\n" + 
			 		"    \r\n" + 
			 		"         \r\n" + 
			 		"          <br>  <center></center>\r\n" + 
			 		"            <li><a href=\"../../../Products/addProductService/addProduct\">Add New Product <i class='fas fa-plus-square'></i></a></li>\r\n" + 
			 		"            <li><a href=\"../../../Products/ProductsService/Products\">All Products & Edit Products <i class='fab fa-elementor'></i></a>\r\n" + 
			 		"            <li><a href=\"../../../Products/AdminMessageViewService/MessageView\">Messages Received <i class='fas fa-comment-alt'></i></a></li>\r\n" + 
			 		"            <li><a href=\"../../../Products/AdminCheckService/checkbill\">Orders Received <i class=\"fas fa-archive\"></i></a></li>\r\n" + 
			 		"            <li><a href=\"../../../Products/CanceledOrdersViewService/CanceledView\">Cancel Orders <i class='fas fa-window-close'></i></a></li>\r\n" + 
			 		"            <li><a href=\"../../../Products/DeliveredOrdersViewService/DeliveredView\">Delivered Orders <i class='fas fa-dolly'></i></a></li>\r\n" + 
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
			 		"	\r\n " +  
			 		"<div style=\"color: black; text-align: center; font-size: 22px;\">Delivered Orders <i class='fas fa-dolly'></i></div>"+
					"<br><center><table border='1' id=\"prr\">"
					+ "<tr><th>Email</th>" +
				    "<th>ID</th>" +
				    "<th>quantity</th>" +
				    "<th>price</th>" +
				    "<th>total</th>" +
				    "<th>address</th>" +
				    "<th>city</th>"+
				    "<th>mobile_number</th>" +
				    "<th>order_date</th>" +
				    "<th>delivary_date</th>"+
				    "<th>payment_method</th>" +
				    "<th>transaction_id</th>"+
				    "<th>status</th>" ;
				  
			 String query = "select *from carts  where  carts.status='Delivered'";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 
			 // iterate through the rows in the result set
				
			 while (rs.next())
			 {
				 String email = rs.getString("email");
				 String ID = Integer.toString(rs.getInt("ID"));
				 String quantity = Integer.toString(rs.getInt("quantity"));
				 String price = Integer.toString(rs.getInt("price"));
				 String total = Integer.toString(rs.getInt("total"));
				 String address = rs.getString("address");
				 String city = rs.getString("city");
				 String mobile_number = Integer.toString(rs.getInt("mobile_number"));
				 String order_date = rs.getString("order_date");
				 String delivary_date = rs.getString("delivary_date");
				 String payment_method = rs.getString("payment_method");
				 String transaction_id = rs.getString("transaction_id");
				 String status = rs.getString("status");
				 
				 // Add into the html table
				 output += "<tr><td>" + email + "</td>";
				 output += "<td>" + ID + "</td>";
				 output += "<td>" + quantity + "</td>";
				 output += "<td>" + price + "</td>";
				 output += "<td>" + total + "</td>";
				 output += "<td>" + address + "</td>";
				 output += "<td>" + city + "</td>";
				 output += "<td>" + mobile_number + "</td>";
				 output += "<td>" + order_date + "</td>";
				 output += "<td>" + delivary_date + "</td>";
				 output += "<td>" + payment_method + "</td>";
				 output += "<td>" + transaction_id + "</td>";
				 output += "<td>" + status + "</td></tr>";
			
				 }
				 con.close();
				 
				 // Complete the html table
				 	output += "</table><br><br><footer class=\"page-footer font-small color-dark\" style=\"background-color:#1f3a93\">\r\n" + 
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
			 output = "Error while reading the items.";
			 System.err.println(e.getMessage());
		}
		
		return output;
		}
	
	public String AdminReadCanceledOr()
	 {
		
		 String output = "";
		
		 try
		 {
			Connection con = connect();
			
			if (con == null) 
			{return "Error while connecting to the database for reading."; }
			
			output ="<html>\r\n" + 
			 		"<head>\r\n" + 
			 		"<link rel=\"stylesheet\" href=\"../css/homee-style.css\">\r\n" + 
			 		"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
			 		"<script src='https://kit.fontawesome.com/a076d05399.js'></script>\r\n" + 
			 		"					<link rel=\"stylesheet\" href=\"Home.css\">\r\n" + 
			 		"					<!-- bootstrap --> \r\n" + 
			 		"					 <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \r\n" + 
			 		"					\r\n" + 
			 		"					 <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"  \r\n" + 
			 		"					 integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\"> \r\n" + 
			 		"					\r\n" + 
			 		"					 <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\"\r\n" + 
			 		"					 <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
			 		"					 <script src='https://kit.fontawesome.com/a076d05399.js'></script> \r\n" + 
			 		"					 </head>\r\n" + 
			 		"					 <title>GadgetBadget</title> \r\n" + 
			 		"					 		</head> \r\n" + 
			 		"					 		\r\n" + 
			 		"					 		<body> \r\n" + 
			 		"					 		 \r\n" + 
			 		"					 		  <nav  class=\"navbar fixed-top navbar-white bg-white\"> \r\n" + 
			 		"					 				<div class= \"container\">\r\n" + 
			 		"					 					<a class=\"navbar-brand\" href=\"#\"> \r\n" + 
			 		"					 		   			 <img src=\"../images/Capture.png\" alt=\"logo\" width=\"220\" height=\"95\" float=\"left\">\r\n" + 
			 		"					 		 			</a> \r\n" + 
			 		"					 		   			<br>\r\n" + 
			 		"					 		   			<div class=\"topnav\" id=\"myTopnav\">\r\n" + 
			 		"					 					  <a href=\"#\" class=\"active\">Home</a>  \r\n" + 
			 		"					 					  <a href=\"#\">Products</a>  \r\n" + 
			 		"					 					  <a href=\"#\">Projects</a> \r\n" + 
			 		"					 					  <a href=\"#\">Funding HelpDesk</a>\r\n" + 
			 		"					 					  <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\"> \r\n" + 
			 		"					 					    <i class=\"fa fa-bars\"></i> \r\n" + 
			 		"					 					  </a> \r\n" + 
			 		"					 					</div>\r\n" + 
			 		"					 					<button class=\"btn\"><i class=\"fa fa-shopping-cart\" style=\"font-size:24px\"></i></button> \r\n" + 
			 		"					 		\r\n" + 
			 		"					 					<div class=\"dropdown\">\r\n" + 
			 		"					 				   <img src=\"../images/avatar.png\" class=\"img-fluid\" alt=\"avatar1\" width=\"50\" height=\"78\" >\r\n" + 
			 		"					 				  <div class=\"dropdown-content\"> \r\n" + 
			 		"					 					    <a href=\"#\">Sign Up</a> \r\n" + 
			 		"					 					    <a href=\"#\">Log In</a> \r\n" + 
			 		"					 					  </div> \r\n" + 
			 		"					 					</div>  \r\n" + 
			 		"					 					\r\n" + 
			 		"					 				</div>  \r\n" + 
			 		"					 			  \r\n" + 
			 		"					 			</nav> \r\n" + 
			 		"					 			 \r\n" + 
			 		"					 			<br> \r\n" + 
			 		"					 		  <br><br> \r\n" + 
			 		"					 		"+
			 		"</head>\r\n" + 
			 		"    <!--Header-->\r\n" + 
			 		"    <br>\r\n" + 
			 		"    <div class=\"topnav sticky\">\r\n" + 
			 		"    \r\n" + 
			 		"         \r\n" + 
			 		"            <br><center></center>\r\n" + 
			 		"            <li><a href=\"../../../Products/addProductService/addProduct\">Add New Product <i class='fas fa-plus-square'></i></a></li>\r\n" + 
			 		"            <li><a href=\"../../../Products/ProductsService/Products\">All Products & Edit Products <i class='fab fa-elementor'></i></a>\r\n" + 
			 		"            <li><a href=\"../../../Products/AdminMessageViewService/MessageView\">Messages Received <i class='fas fa-comment-alt'></i></a></li>\r\n" + 
			 		"            <li><a href=\"../../../Products/AdminCheckService/checkbill\">Orders Received <i class=\"fas fa-archive\"></i></a></li>\r\n" + 
			 		"            <li><a href=\"../../../Products/CanceledOrdersViewService/CanceledView\">Cancel Orders <i class='fas fa-window-close'></i></a></li>\r\n" + 
			 		"            <li><a href=\"../../../Products/DeliveredOrdersViewService/DeliveredView\">Delivered Orders <i class='fas fa-dolly'></i></a></li>\r\n" + 
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
			 		"	\r\n " +  
			 		"<div style=\"color: black; text-align: center; font-size: 22px;\">Canceled Orders <i class='fas fa-window-close'></i></div>"+
					"<br><center><table border='1' id=\"prrc\">"
					+ "<tr><th>Email</th>" +
				    "<th>ID</th>" +
				    "<th>quantity</th>" +
				    "<th>price</th>" +
				    "<th>total</th>" +
				    "<th>address</th>" +
				    "<th>city</th>"+
				    "<th>mobile_number</th>" +
				    "<th>order_date</th>" +
				    "<th>delivary_date</th>"+
				    "<th>payment_method</th>" +
				    "<th>transaction_id</th>"+
				    "<th>status</th>" ;
		
			 String query = 	"select *from carts  where order_date is not NULL and status='Cancel'";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 
			 // iterate through the rows in the result set
				
			 while (rs.next())
			 {
				 String email = rs.getString("email");
				 String ID = Integer.toString(rs.getInt("ID"));
				 String quantity = Integer.toString(rs.getInt("quantity"));
				 String price = Integer.toString(rs.getInt("price"));
				 String total = Integer.toString(rs.getInt("total"));
				 String address = rs.getString("address");
				 String city = rs.getString("city");
				 String mobile_number = Integer.toString(rs.getInt("mobile_number"));
				 String order_date = rs.getString("order_date");
				 String delivary_date = rs.getString("delivary_date");
				 String payment_method = rs.getString("payment_method");
				 String transaction_id = rs.getString("transaction_id");
				 String status = rs.getString("status");
				 
				 // Add into the html table
				 output += "<tr><td>" + email + "</td>";
				 output += "<td>" + ID + "</td>";
				 output += "<td>" + quantity + "</td>";
				 output += "<td>" + price + "</td>";
				 output += "<td>" + total + "</td>";
				 output += "<td>" + address + "</td>";
				 output += "<td>" + city + "</td>";
				 output += "<td>" + mobile_number + "</td>";
				 output += "<td>" + order_date + "</td>";
				 output += "<td>" + delivary_date + "</td>";
				 output += "<td>" + payment_method + "</td>";
				 output += "<td>" + transaction_id + "</td>";
				 output += "<td>" + status + "</td></tr>";
			
				 }
				 con.close();
				 
				 // Complete the html table
					output += "</table></center><br><br><footer class=\"page-footer font-small color-dark\" style=\"background-color:#1f3a93\">\r\n" + 
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
			 output = "Error while reading the items.";
			 System.err.println(e.getMessage());
		}
		
		return output;
		}
	
	public String insertCart(String email,int ID,int quantity1,String price)
	 {
		
		 	String output = "";
		 	int product_price = 0;
			int product_total = 0;
			int cart_total = 0;
			int quantity = 1;
			
			
			int z=0;
			
			try{
				Connection con = connect();
				if (con == null)
				{
					return "Error while connecting to the database for inserting."; 
				}
						
				Statement st = con.createStatement();
				ResultSet rs= st.executeQuery("select *from products where ID = '"+ID+"'");
				while(rs.next())
				{
					product_price = rs.getInt(6);
					product_total = product_price;
							
				}
			
			
				ResultSet rs1= st.executeQuery("select * from carts where ID = '"+ID+"' and email = '"+email+"' and  address is NULL");
				
				while(rs1.next())
				{
					
					cart_total = rs1.getInt(5);
					cart_total=cart_total+product_total;
					quantity=rs1.getInt(3);
					quantity=quantity+1;
					z=1;
				}
				
				if(z == 1 )
				{
					st.executeUpdate("update carts set total ='"+cart_total+"',quantity='"+quantity+"' where ID='"+ID+"' and email ='"+email+"' and address is null");
					output = "update successfully";
				}
				
				if(z==0)
				{
					PreparedStatement ps=con.prepareStatement("insert into carts(email,ID,quantity,price,total)values(?,?,?,?,?)");
					ps.setString(1,email);
					ps.setInt(2,ID);
					ps.setInt(3,quantity);
					ps.setInt(4,product_price);
					ps.setInt(5,product_total);
					
					ps.execute();
					con.close();
					output = "Inserted successfully";
					
				}
			}catch(Exception e){
				
				output = "Error while inserting the item.";
				System.err.println(e.getMessage());
					
			}
						
			     return output;
			 }
	
	
	public String insertDeliveredStatus(String email , int ID, String status1)
	 {
		
		 	String output = "";
			String status="Delivered";
		
			try{
				Connection con = connect();
				if (con == null)
				{
					return "Error while connecting to the database for inserting."; 
				}
				Statement st = con.createStatement();
				System.out.println(ID);
				System.out.println(status);
				System.out.println(email);
				st.executeUpdate("update carts set status='"+status+"' where ID='"+ID+"' and email='"+email+"' and address is not NULL");
				output = "Updated as 'Delivered' successfully";
					
			
			
			}catch(Exception e){
				
				output = "Error while inserting the item.";
				System.err.println(e.getMessage());
					
			}
						
			     return output;
			}
	
	
	
	
	public String insertCancelStatus(String email , int ID, String status1)
	 {
		
		 	String output = "";
			String status="Cancel";
		
			try{
				Connection con = connect();
				if (con == null)
				{
					return "Error while connecting to the database for inserting."; 
				}
				Statement st = con.createStatement();
				System.out.println(ID);
				System.out.println(status);
				System.out.println(email);
				st.executeUpdate("update carts set status='"+status+"' where ID='"+ID+"' and email='"+email+"' and address is not NULL");
				output = "canceled successfully";
					
			
			
			}catch(Exception e){
				
				output = "Error while inserting the item.";
				System.err.println(e.getMessage());
					
			}
						
			     return output;
			}
	
	
	public String CheckOr()
	 {
		
		 String output = "";
		
		 try
		 {
			Connection con = connect();
			
			if (con == null) 
			{return "Error while connecting to the database for reading."; }
			
			output ="<html>\r\n" + 
			 		"<head>\r\n" + 
			 		"<link rel=\"stylesheet\" href=\"../css/homee-style.css\">\r\n" + 
			 		"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
			 		"<script src='https://kit.fontawesome.com/a076d05399.js'></script>\r\n" + 
			 		"					<link rel=\"stylesheet\" href=\"Home.css\">\r\n" + 
			 		"					<!-- bootstrap --> \r\n" + 
			 		"					 <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \r\n" + 
			 		"					\r\n" + 
			 		"					 <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"  \r\n" + 
			 		"					 integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\"> \r\n" + 
			 		"					\r\n" + 
			 		"					 <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\"\r\n" + 
			 		"					 <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
			 		"					 <script src='https://kit.fontawesome.com/a076d05399.js'></script> \r\n" + 
			 		"					 </head>\r\n" + 
			 		"					 <title>GadgetBadget</title> \r\n" + 
			 		"					 		</head> \r\n" + 
			 		"					 		\r\n" + 
			 		"					 		<body> \r\n" + 
			 		"					 		 \r\n" + 
			 		"					 		  <nav  class=\"navbar fixed-top navbar-white bg-white\"> \r\n" + 
			 		"					 				<div class= \"container\">\r\n" + 
			 		"					 					<a class=\"navbar-brand\" href=\"#\"> \r\n" + 
			 		"					 		   			 <img src=\"../images/Capture.png\" alt=\"logo\" width=\"220\" height=\"95\" float=\"left\">\r\n" + 
			 		"					 		 			</a> \r\n" + 
			 		"					 		   			<br>\r\n" + 
			 		"					 		   			<div class=\"topnav\" id=\"myTopnav\">\r\n" + 
			 		"					 					  <a href=\"#\" class=\"active\">Home</a>  \r\n" + 
			 		"					 					  <a href=\"#\">Products</a>  \r\n" + 
			 		"					 					  <a href=\"#\">Projects</a> \r\n" + 
			 		"					 					  <a href=\"#\">Funding HelpDesk</a>\r\n" + 
			 		"					 					  <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\"> \r\n" + 
			 		"					 					    <i class=\"fa fa-bars\"></i> \r\n" + 
			 		"					 					  </a> \r\n" + 
			 		"					 					</div>\r\n" + 
			 		"					 					<button class=\"btn\"><i class=\"fa fa-shopping-cart\" style=\"font-size:24px\"></i></button> \r\n" + 
			 		"					 		\r\n" + 
			 		"					 					<div class=\"dropdown\">\r\n" + 
			 		"					 				   <img src=\"../images/avatar.png\" class=\"img-fluid\" alt=\"avatar1\" width=\"50\" height=\"78\" >\r\n" + 
			 		"					 				  <div class=\"dropdown-content\"> \r\n" + 
			 		"					 					    <a href=\"#\">Sign Up</a> \r\n" + 
			 		"					 					    <a href=\"#\">Log In</a> \r\n" + 
			 		"					 					  </div> \r\n" + 
			 		"					 					</div>  \r\n" + 
			 		"					 					\r\n" + 
			 		"					 				</div>  \r\n" + 
			 		"					 			  \r\n" + 
			 		"					 			</nav> \r\n" + 
			 		"					 			 \r\n" + 
			 		"					 			<br> \r\n" + 
			 		"					 		  <br><br> \r\n" + 
			 		"					 		"+
			 		"</head>\r\n" + 
			 		"    <!--Header-->\r\n" + 
			 		"    \r\n" + 
			 		"    <div class=\"topnav sticky\">\r\n" + 
			 		"    \r\n" + 
			 		"         \r\n" + 
			 		"           <br><br> <center></center>\r\n" + 
			 		"            <li><a href=\"../../../Products/addProductService/addProduct\">Add New Product <i class='fas fa-plus-square'></i></a></li>\r\n" + 
			 		"            <li><a href=\"../../../Products/ProductsService/Products\">All Products & Edit Products <i class='fab fa-elementor'></i></a>\r\n" + 
			 		"            <li><a href=\"../../../Products/AdminMessageViewService/MessageView\">Messages Received <i class='fas fa-comment-alt'></i></a></li>\r\n" + 
			 		"            <li><a href=\"../../../Products/AdminCheckService/checkbill\">Orders Received <i class=\"fas fa-archive\"></i></a></li>\r\n" + 
			 		"            <li><a href=\"../../../Products/CanceledOrdersViewService/CanceledView\">Cancel Orders <i class='fas fa-window-close'></i></a></li>\r\n" + 
			 		"            <li><a href=\"../../../Products/DeliveredOrdersViewService/DeliveredView\">Delivered Orders <i class='fas fa-dolly'></i></a></li>\r\n" + 
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
			 		"	\r\n " +  
			 		"<div style=\"color: black; text-align: center; font-size: 22px;\">Orders Received<i class=\"fas fa-archive\"></i></div>"+
					"<br><center><table border='1' id=\"prx\">"
					+ "<tr><th>Email</th>" +
				    "<th>ID</th>" +
				    "<th>quantity</th>" +
				    "<th>price</th>" +
				    "<th>total</th>" +
				    "<th>address</th>"+
				    "<th>mobile_number</th>" +
				    "<th>order_date</th>" +
				    "<th>delivary_date</th>"+
				    "<th>payment_method</th>" +
				    "<th>status</th>"+
				    "<th>Cancel</th>"+
				    "<th>Deliver</th>";
				  
			 String query = "select * from carts where order_date is not NULL and status='processing'";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 
			 // iterate through the rows in the result set
				
			 while (rs.next())
			 {
				 String email = rs.getString("email");
				 String ID = Integer.toString(rs.getInt("ID"));
				 String quantity = Integer.toString(rs.getInt("quantity"));
				 String price = Integer.toString(rs.getInt("price"));
				 String total = Integer.toString(rs.getInt("total"));
				 String address = rs.getString("address");
				 String mobile_number = Integer.toString(rs.getInt("mobile_number"));
				 String order_date = rs.getString("order_date");
				 String delivary_date = rs.getString("delivary_date");
				 String payment_method = rs.getString("payment_method");
				 String status = rs.getString("status");
				 
				 // Add into the html table
				 output += "<tr><td>" + email + "</td>";
				 output += "<td>" + ID + "</td>";
				 output += "<td>" + quantity + "</td>";
				 output += "<td>" + price + "</td>";
				 output += "<td>" + total + "</td>";
				 output += "<td>" + address + "</td>";
				 output += "<td>" + mobile_number + "</td>";
				 output += "<td>" + order_date + "</td>";
				 output += "<td>" + delivary_date + "</td>";
				 output += "<td>" + payment_method + "</td>";
				 output += "<td>" + status + "</td>";
			
				 // buttons
				 output += "<td><form method='post' action='../../../Products/AdminCheckService/checkbill/addCancelStatus'>"
						 +"<button type='submit' class='button button3' >Cancel</button>"
						 +"<input type='hidden' name='ID' value='"+ID+"'>"
						 +"<input type='hidden' name='email' value='"+email+"'>"
						 +"<input type='hidden' name='ststus' value='Delivered'>"
						 +"</form></td>"
						 + "<td><form method='post' action='../../../Products/AdminCheckService/checkbill/addDeliverStatus'>"
						 + "<button type='submit' class='button button33'>Deliver</button>"
						 +"<input type='hidden' name='ID' value='"+ID+"'>"
						 +"<input type='hidden' name='email' value='"+email+"'>"
						 +"<input type='hidden' name='ststus' value='Cancel'>"
						+ "</form></td></tr>";
				 }
				 con.close();
				 
				 // Complete the html table
					output += "</table></center><br><br><footer class=\"page-footer font-small color-dark\" style=\"background-color:#1f3a93\">\r\n" + 
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
			 output = "Error while reading the items.";
			 System.err.println(e.getMessage());
		}
		
		return output;
		}
}