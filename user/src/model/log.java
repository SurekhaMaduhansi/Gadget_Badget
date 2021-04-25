package model;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.jsoup.helper.HttpConnection.Response;

import model.user;
import com.logService;
import com.mysql.cj.Session;


public class log {
	
	private static boolean isSucess;
	
	private static Connection connect() 
	 { 
	 Connection con = null; 
	 try
	 { 
	 Class.forName("com.mysql.cj.jdbc.Driver"); 
	 
	 //Provide the correct details: DBServer/DBName, username, password 
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user?useTimezone=true&serverTimezone=UTC", "root", ""); 
	 } 
	 catch (Exception e) 
	 {e.printStackTrace();} 
	 return con; 
	 }
	
	

		public String readLog() 
		 { 
			 String output = ""; 
			 try
			 { 
			 Connection con = connect(); 
			 if (con == null) 
			 {return "Error while connecting to the database for reading."; } 
			 // Prepare the html table to be displayed
			 output = "<html>\r\n" + 
			 		"<head>\r\n" + 
			 		"<meta charset=\"ISO-8859-1\">\r\n" + 
			 		"\r\n" + 
			 		"	<link rel=\"stylesheet\" href=\"../../../user/Home.css\">\r\n" + 
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
			 		"     			 <img src=\"../../../user/images/Capture.PNG\" alt=\"logo\" width=\"220\" height=\"78\" float=\"left\">\r\n" + 
			 		"   			</a>\r\n" + 
			 		"   			<br>\r\n" + 
			 		"   			<div class=\"topnav\" id=\"myTopnav\">\r\n" + 
			 		"			  <a href=\"#\" class=\"active\">Home</a>\r\n" + 
			 		"			  <a href=\"#\">Products</a>\r\n" + 
			 		"			  <a href=\"#\">My Projects</a>\r\n" + 
			 		"			  \r\n" + 
			 		"			  <a href=\"#\">Funding HelpDesk</a>\r\n" + 
			 		"			  <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\">\r\n" + 
			 		"			    <i class=\"fa fa-bars\"></i>\r\n" + 
			 		"			  </a>\r\n" + 
			 		"			\r\n" + 
			 		"			</div>\r\n" + 
			 		"			\r\n" + 
			 		"			<div class=\"dropdown\">\r\n" + 
			 		"			   <img src=\"../../../user/images/avatar.png\" class=\"img-fluid\" alt=\"avatar1\" width=\"50\" height=\"80\" >\r\n" + 
			 		"			</div>			\r\n" + 
			 		"		</div>	\r\n" + 
			 		"	</nav>\r\n" + 
			 		"	\r\n" + 
			 		"<!-- navigation bar -->\r\n" + 
			 		"	<br>\r\n" + 
			 		" 	<img class=\"card-img-top\" src=\"../../../user/images/admin.jpg\" alt=\"Card image cap\"  height=\"510\">\r\n" + 
			 		"  <br><br><br>\r\n" + 
			 		"  \r\n" + 
			 		"  \r\n" + 
			 		"  <center><h3> Welcome to GadgetBadget </h3></center>\r\n" + 
			 		" <br><br><br>" + 
			 		"<!-- ================form============================================================================================= -->\r\n"
			 		+"<center>"
			 		+"<div class=\"card border-primary mb-3\" style='width: 500px'>"
			 		+"<center><h5 style='color:red'>Enter your login details....</h5><br>"
			 		+ "<form action='../../../user/logService/log/logUser' method='post'>"
			 		
			 		+"<label for=\"exampleFormControlInput1\">Email address</label>\r\n" 
			 		+"<input class=\"form-control\" type=\"text\" placeholder=\"Enter email\" name=\"email\" required>"
			 		
			 		+"<label for=\"exampleFormControlInput1\">Password</label>\r\n" 
			 		+"<input class=\"form-control\" type=\"password\" placeholder=\"Enter your password\" name=\"password\" required>\n"
			 		
					+"	<input type='submit' value='Login' class='btn btn-success' ></center>" 
			 		+ "</form>" 
			 		+"</div>"
			 		+"</center>"+
			 		
			 	
			 		"<!-- ======================end of the form======================================================================================= -->\r\n" + 
			 		"<!-- Footer -->\r\n" + 
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
			 output = "Error while reading the user."; 
			 System.err.println(e.getMessage()); 
			 } 
			 
			 
		 return output; 
		 
	} 
		
		
		
		
		public String login(String UserEmail, String password)
		{
			
			String output = ""; 
			 try
			 { 
			 Connection con = connect(); 
			 if (con == null) 
			 {return "Error while connecting to the database for inserting."; } 
			 // create a prepared statement
			 String query =  "select UserEmail, password, type from users where UserEmail='"+UserEmail+"'";
			 
			 Statement stmt = con.createStatement(); 
			 ResultSet rs = stmt.executeQuery(query);
			 String get_password = "";
			 String get_type = "";
			 int i =0;
			 while(rs.next()) {
				 get_password = rs.getString("password");
				 get_type = rs.getString("type");
				 i++;
			 }
			 
			 if(i>0) {
				 
				 
				 if(get_password.equals(password)) {
					 
					
					 
					 if(get_type.equals("Admin")) {
						 
						 System.out.println("logged in as a admin");
						 
					 }else if(get_type.equals("customer")) {
						 System.out.println("logged in as a customer");
					 }else {
						 System.out.println("logged in user type cannot found!");
					 }
 
					 
					 
				 }else {
					 System.out.println("Password Password incorrect");
				 }
			 }else {
				 System.out.println("Username Password incorrect");
			 }
			 con.close(); 
			 output = "";
			
			 } 
			 catch (Exception e) 
			 { 
			 output = "Error while inserting the item."; 
			 System.err.println(e.getMessage()); 
			 } 
			 return output; 
		}
	
	//validate the user loging
		
	public boolean validate(String email ,String password){
		 boolean isSucess = false;
		ArrayList<user> us =new ArrayList<>();
				
		//validate
		try { 
			
			 Connection con = connect(); 
			 if (con == null) 
			 {
				return isSucess;
				 } 
			
			 String sql="select * from users where email='"+email+"' , password='"+password+"'"; 
			 Statement stmt = con.createStatement(); 
			 ResultSet rs = stmt.executeQuery(sql); 
			
			 if(rs.next()) {
					
				 isSucess=true;
			 }else
				 {
				 	
				 	isSucess=false;
				 
				 }
				
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		return isSucess;
		
	
	}
	
	//getting user details
	public String getuserDetails(String email)
	{
		 String output = ""; 
		
		try {
			
			Connection con = connect(); 
			 if (con == null) 
			 {return "Error while connecting to the database for reading."; }
			
			 String sql="select * from users where email='"+email+"'"; 
			 Statement stmt = con.createStatement(); 
			 ResultSet rs = stmt.executeQuery(sql); 
			
			while(rs.next()) {
			
				String email1=rs.getString(1);
				String fname=rs.getString(2);
				String lname=rs.getString(3);
				String type=rs.getString(4);
				String phone=rs.getString(5);
				String passU=rs.getString(6);
				
				

			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return output;
		
	}

}
