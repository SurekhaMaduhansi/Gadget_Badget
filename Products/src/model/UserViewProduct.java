package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserViewProduct {

	
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
	
	public String insertCart(String email,String product_id,String quantity,String price,String total, String address,String city,String mobile_number,String order_date,String delivary_date,String payment_method,String transaction_id,String status)
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
				 String query = " insert into carts(`email`,`product_id`,`quantity`,`price`,`total`,`address`,`city`,`mobile_number`,`order_date`,`delivary_date`,`payment_method`,`transaction_id`,`status`)"
						 + " values (?, ?, ?, ?, ?,? , ?,?,?,?,?,?,?)";
				 
						 PreparedStatement preparedStmt = con.prepareStatement(query);
						
						 // binding values
						 preparedStmt.setString(1, email);
						 preparedStmt.setString(2, product_id);
						 preparedStmt.setInt(3, Integer.parseInt(quantity));
						 preparedStmt.setInt(4, Integer.parseInt(price));
						 preparedStmt.setInt(5, Integer.parseInt(total));
						 preparedStmt.setString(6, address);
						 preparedStmt.setString(7, city);
						 preparedStmt.setInt(8, Integer.parseInt(mobile_number));
						 preparedStmt.setString(9, order_date);
						 preparedStmt.setString(10, delivary_date);
						 preparedStmt.setString(11, payment_method);
						 preparedStmt.setString(12, transaction_id);
						 preparedStmt.setString(13, status);
						
						 // execute the statement
						 preparedStmt.execute();
						 con.close();
						 output = "Inserted successfully";
				 }
			 
			 
				  catch (Exception e)
				 {
						 output = "Error while inserting the item.";
						 System.err.println(e.getMessage());
				 }
						
			     return output;
			 }
	
	
	

			 public String readProducts()
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
					 		"<link rel=\"stylesheet\" href=\"../css/userHome.css\">\r\n" + 
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
					 		"    <br><br>\r\n" + 
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
					 		" <br><div style=\"color: black; text-align: center; font-size: 22px;\">My Orders <i class='fab fa-elementor'></i></div>"+
					 		"           <br>"
					 		+ "<center><table border='1' id=\"prx\"><tr><th>Email</th>" +
						      "<th>Product Id</th>" +
						      "<th>Quantity</th>" +
						      "<th>Price</th>" +
						      "<th>Total</th>" +
						      "<th>Address</th>" +
						      "<th>City</th>" +
						      "<th>Mobile</th>" +
						      "<th>Order Date</th>" +
						      "<th>Delivary Date</th>" +
						      "<th>Payment Method</th>" +
						      "<th>Transaction ID</th>" +
						      "<th>Status</th>";
					
					 String query = " select *from carts  where ID  and email like 'sa@gmail.com' and order_date is not NULL ";
					 Statement stmt = con.createStatement();
					 ResultSet rs = stmt.executeQuery(query);
					 
					 // iterate through the rows in the result set
			
					 while (rs.next())
					 {
						 String email=rs.getString("email");
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
						 output += "<td>" + status + "</td>";
						 
					
						 // buttons
						 output += "";
						 }
						 con.close();
						 
						 // Complete the html table
						 	output += "</table>";
				 }
				 
				 catch (Exception e)
				 {
					 output = "Error while reading the items.";
					 System.err.println(e.getMessage());
				 }
				 
				 return output;
			}
			 
			 
			 public String readMyCart()
			 {
				
				 String output = "";
				 int total1=0;
				 int sno =0;
			
					 
					 try
					 {
						 Connection con = connect();
						 Statement st = con.createStatement();
						 ResultSet rs1= st.executeQuery("Select sum(total) from carts where email = 'sa@gmail.com' and address is null");
						 
						 while(rs1.next()){
								total1= rs1.getInt(1);
							}
						
					if (con == null) 
					{return "Error while connecting to the database for reading."; }
	
					// Prepare the html table to be displayed
					 output = "<html>\r\n" + 
					 		"<head>\r\n" + 
					 		"<link rel=\"stylesheet\" href=\"../css/userHome.css\">\r\n" + 
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
					 		"   <br> <div class=\"topnav sticky\">\r\n" + 
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
					 		" <div style=\"color: black; text-align: center; font-size: 25px;\">My Orders <i class='fab fa-elementor'></i></div>"+
					 		"           <br>"+

					 		"<center><div \"card text-white bg-warning mb-3\" style=\"max-width: 18rem;\">\r\n" + 
					 		"  <div class=\"card-header\"><center>Total Amount Of The Cart</div>\r\n" + 
					 		"  <div class=\"card-body\">\r\n" + 
					 		"    <h5 class=\"card-title\"><b><center>Rs. " + total1 +"/=</h5>\r\n" + 
					 		
					 		"  </div>\r\n" + 
					 		"</div>"+
					 		"<center><table border='1' id=\"prxxx\"><tr>" +
						      "<th>Product Id</th>" +
						      "<th>Quantity</th>" +
						      "<th>Price</th>" +
						      "<th>Total</th>"+
						      "<th>Remove The Product</th></tr>";
					
					 String query = "  select *from carts where ID and email like 'sa@gmail.com' and carts.address is NULL ";
					 Statement stmt = con.createStatement();
					 ResultSet rs = stmt.executeQuery(query);
					 
					 // iterate through the rows in the result set
			
					 while (rs.next())
					 {
						
						 String CID = Integer.toString(rs.getInt("CID"));
						 String ID = Integer.toString(rs.getInt("ID"));
						 String quantity = Integer.toString(rs.getInt("quantity"));
						 String price = Integer.toString(rs.getInt("price"));
						 String total = Integer.toString(rs.getInt("total"));
				
						 
						 // Add into the html table
						
						 output += "<td>" + ID + "</td>";
						 output += "<td>" + quantity + "</td>";
						 output += "<td>" +"Rs. "+ price + "</td>";
						 output += "<td>" +"Rs. "+ total + "</td>";
						 
		
						 
					
						 // buttons
						 output += "<td><form method='post' action='../../../Products/MyCartService/viewMyCart/DeleteProductCart'>"
								 + "<button type='submit' class='button11 button1'><b>Remove <i class='fas fa-cart-arrow-down'></i></b></button>"
								 + "<input name='email' type='hidden' value='sa@gmail.com'>" 
								 + "<input name='ID' type='hidden' value='"+CID+"'>" 
								 + "</form></td></tr>"
								 ;
						 }
						 con.close();
						 
						 // Complete the html table
						 	output += "</table><br>"+
						 			
						 			"<div class=\"alert alert-success\" role=\"alert\">\r\n" + 
						 			"  <h4 class=\"alert-heading\">Proceed to Order!</h4>\r\n" + 
						 			"  <p>You can proceed the order by pressing button bellow.</p>\r\n" + 
						 			"  <hr>\r\n" + 
						 			"  <p class=\"mb-0\">"
						 			+ "<form method='post' action='../../../Products/BillService/bill' >"
						 			+ "<button type='submit' class='button'><b> Order -></p>\r\n" + 
						 			"</div></div></form>";
				 }
				 
				 catch (Exception e)
				 {
					 output = "Error while reading the items.";
					 System.err.println(e.getMessage());
				 }
				 
				 return output;
			}
		
			 public String UserDeleteProduct(String CID)
				{
						 String output = "";
						
						 try
						 {
							 Connection con = connect();
							
							 if (con == null)
							 {return "Error while connecting to the database for deleting."; }
									
							 // create a prepared statement
							 String query = "delete from carts where CID=?";
							 PreparedStatement preparedStmt = con.prepareStatement(query);
								
							 // binding values
							 preparedStmt.setInt(1, Integer.parseInt(CID));
							
							 // execute the statement
							 preparedStmt.execute();
							 con.close();
							 output = "Deleted successfully";
						 }
								
						 catch (Exception e)
						 {
							 output = "Error while deleting the item.";
							 System.err.println(e.getMessage());
						 }
						 return output;
				}
			 
			 public String insertBill(String address, String city, String mobile_number, String transaction_id,String status, String email)
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
						 String query = " update carts set address =?, city =? , mobile_number =?, order_date = now(),delivary_date= DATE_ADD(order_date, INTERVAL 7 DAY),payment_method=?,transaction_id = ?,status=? where email='sa@gmail.com' and address is NULL";
						 
								 PreparedStatement preparedStmt = con.prepareStatement(query);
								
								 // binding values
								 preparedStmt.setString(1, address);
								 preparedStmt.setString(2, city);
								 preparedStmt.setInt(3, Integer.parseInt(mobile_number));
								 preparedStmt.setString(4, transaction_id);
								 preparedStmt.setString(5, status);
								 preparedStmt.setString(6, email);
								
								 // execute the statement
								 preparedStmt.execute();
								 con.close();
								 output = "Updated successfully";
						 }
					 
					 
						  catch (Exception e)
						 {
								 output = "Error while inserting the item.";
								 System.err.println(e.getMessage());
						 }
								
					     return output;
					 }

			 public String readBill()
			 {
				
				 String output = "";
				
				 try
				 {
					Connection con = connect();
					
					if (con == null) 
					{return "Error while connecting to the database for reading."; }
					
					output ="<html>\r\n" + 
							"<head>\r\n" + 
							
							"<link rel=\"stylesheet\" href=\"../css/user.css\">"+ 
							"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
					
 							"<script src='https://kit.fontawesome.com/a076d05399.js'></script>\r\n" + 
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
							"        \r\n" + 
							
							"           <!--table-->\r\n" + 
							
							"<center>	"+
							"\r\n" + 
							"		<center><div class=\"bg-img\" >\r\n" + 
							"		\r\n" + 
							"	<form action = \"addressPaymentForOrderAction.jsp\" method=\"post\" class=\"container\">\r\n" + 
							"\r\n" + 
							"			\r\n" + 
							"					<b>\r\n" + 
							"		             Enter Address<input type =\"text\" name =\"address\"  placeholder=\"Enter the address..\" required><br><br>\r\n" + 
							"					 Enter city<input type =\"text\" name =\"city\" placeholder=\"Enter the city...\" required><br><br>\r\n" + 
							"					 Mobile Number<input type =\"text\" name =\"mobile_number\"  placeholder=\"Enter the mobile number..\" required><br><br>\r\n" + 
							"					 Select way of Payment<br><select name = \"payment_method\"><br><br>\r\n" + 
							"					    <option value=\"\"></option>\r\n" + 
							"					    <option value=\"Cash On Delivery(COD)\">Cash On Delivery(COD)</option>\r\n" + 
							"					 	<option value=\"Online Payment\">Online Payment</option>\r\n" + 
							"					 </select><br><br>\r\n" + 
							"					 Transaction ID<input type =\"text\" name =\"transaction_id\"  placeholder =\"Enter the transaction id..\" ><br>\r\n" + 
							"					 <p style=\"color:#cf000f; font-size: 14px;\">*If you selected online payment option, then fill this field!!, Otherwise keep this empty!!</p>\r\n" + 
							"          <button type=\"submit\" class=\"button button5\">Proceed to Generate Bill & Save</button>\r\n" + 
							"								    \r\n" + 
							"		</form>\r\n" + 
							"		</div></center>"
							;
				
				}
				
				catch (Exception e)
				{
					 output = "Error while reading the items.";
					 System.err.println(e.getMessage());
				}
				
				return output;
				}
}
