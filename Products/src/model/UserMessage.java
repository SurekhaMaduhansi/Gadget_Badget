
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
					"				<button type=\"submit\">Send</button>\r\n" + 
					"				"; 
				
			
			
			
		 }
		 catch (Exception e)
		 {
			 output = "Error while reading the items.";
			 System.err.println(e.getMessage());
		 }
		 
		 return output;
		 
	 }
	
}