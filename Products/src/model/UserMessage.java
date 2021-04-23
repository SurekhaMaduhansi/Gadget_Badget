
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
		 Class.forName("com.mysql.jdbc.Driver");
		
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagement", "root", "");

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
					"<link rel=\"stylesheet\" href=\"../css/CartuserHome.css\">\r\n" + 
					"<link rel=\"stylesheet\" href=\"../css/messageUs.css\">\r\n" + 
					"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
					"<script src='https://kit.fontawesome.com/a076d05399.js'></script>\r\n" + 
					"</head>\r\n" + 
					"    <!--Header-->\r\n" + 
					"    <br>\r\n" + 
					"    <div class=\"topnav sticky\">\r\n" + 
					
					"    \r\n" + 
					"          \r\n" + 
					"           <b> <h2><a href=\"\">sa@gmail.com <i class='fas fa-user-alt'></i></a></h2>\r\n" + 
					
					"            <a href=\"../../../Products/UserHomeService/AllProducts\">Home<i class=\"fa fa-institution\"></i></a>\r\n" + 
					"            <a href=\"myCart.jsp\">My Cart<i class='fas fa-cart-arrow-down'></i></a>\r\n" + 
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
					"<div style=\"color: black; text-align: center; font-size: 25px;\">Message Us <i class='fas fa-comment-alt'></i></div>"+
					"	<form action='../../../Products/UserMessageService/messageUser/AddMessage' method=\"post\">\r\n" +
					"               <input type='hidden' name='email' value='sa@gmail.com'>"+//hardcoded
					"				<input class=\"input-style\" name=\"subject\" type =\"text\" placeholder=\"subject....\" required>\r\n" + 
					"				<hr>\r\n" + 
					"				<textarea class=\"input-style\" name=\"body\" type =\"text\" placeholder=\"Enter Your Message....\" required></textarea>\r\n" + 
					"				<hr>\r\n" + 
					"				<button type=\"submit\">Send</button>\r\n" ;
		
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
			 		"</head>\r\n" + 
			 		"    <!--Header-->\r\n" + 
			 		"    <br>\r\n" + 
			 		"    <div class=\"topnav sticky\">\r\n" + 
			 		"    \r\n" + 
			 		"         \r\n" + 
			 		"            <center></center>\r\n" + 
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
				 	output += "</table>";
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
			 		"</head>\r\n" + 
			 		"    <!--Header-->\r\n" + 
			 		"    <br>\r\n" + 
			 		"    <div class=\"topnav sticky\">\r\n" + 
			 		"    \r\n" + 
			 		"         \r\n" + 
			 		"            <center></center>\r\n" + 
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
				  
			 String query = "select *from carts inner join products where  carts.status='Delivered'";
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
				 	output += "</table>";
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
			 		"</head>\r\n" + 
			 		"    <!--Header-->\r\n" + 
			 		"    <br>\r\n" + 
			 		"    <div class=\"topnav sticky\">\r\n" + 
			 		"    \r\n" + 
			 		"         \r\n" + 
			 		"            <center></center>\r\n" + 
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
				  
			 String query = "select *from carts inner join products where  carts.status='Cancel'";
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
				 	output += "</table>";
		}
		
		catch (Exception e)
		{
			 output = "Error while reading the items.";
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
			 		"<link rel=\"stylesheet\" href=\"../css/userHome.css\">\r\n" + 
			 		"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
			 		"<script src='https://kit.fontawesome.com/a076d05399.js'></script>\r\n" + 
			 		"</head>\r\n" + 
			 		"    <!--Header-->\r\n" + 
			 		"    <br>\r\n" + 
			 		"    <div class=\"topnav sticky\">\r\n" + 
			 		"    \r\n" + 
			 		"         \r\n" + 
			 		"            <center></center>\r\n" + 
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
				    "<th>address</th>" +
				    "<th>city</th>"+
				    "<th>mobile_number</th>" +
				    "<th>order_date</th>" +
				    "<th>delivary_date</th>"+
				    "<th>payment_method</th>" +
				    "<th>transaction_id</th>"+
				    "<th>status</th>"+
				    "<th>Cancel</th>"+
				    "<th>Deliver</th>";
				  
			 String query = "select *from carts inner join products where  carts.status='bil'";
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
				 output += "<td>" + status + "</td>";
			
				 // buttons
				 output += "<td><button class='button button3'>Cancel</button></td>"
						 + "<td><form method='post' action='../../../Products/ProductsService/Products/Delete'>"
						 + "<button class='button button33'>Deliver</button>"
						+ "</form></td></tr>";
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
}