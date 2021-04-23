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
					 		" <div style=\"color: black; text-align: center; font-size: 25px;\">My Orders <i class='fab fa-elementor'></i></div>"+
					 		"           <br>"
					 		+ "<center><table border='1'><tr><th>Email</th>" +
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
					
					 String query = " select *from carts inner join products where carts.ID  and carts.email like 'sa@gmail.com' and carts.order_date is not NULL ";
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
			 
			 
			 
		
	
}
