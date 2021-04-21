package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Products;
import com.ProductsService;

import model.addProduct;
import com.addProductService;

public class admin {
	
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

	
	
	 public String readItems()
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
			 		"            <li><a href=\"messagesReceived.jsp\">Messages Received <i class='fas fa-comment-alt'></i></a></li>\r\n" + 
			 		"            <li><a href=\"ordersReceived.jsp\">Orders Received <i class=\"fas fa-archive\"></i></a></li>\r\n" + 
			 		"            <li><a href=\"cancelOrders.jsp\">Cancel Orders <i class='fas fa-window-close'></i></a></li>\r\n" + 
			 		"            <li><a href=\"deliveredOrders.jsp\">Delivered Orders <i class='fas fa-dolly'></i></a></li>\r\n" + 
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
			 		"           <br><script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n" + 
			 		"	<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n" + 
			 		"	<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n" + 
			 		"<!-- bootstrap -->";
			 		
		
 
	 }
		 catch (Exception e)
		 {
			 output = "Error while reading the items.";
			 System.err.println(e.getMessage());
		 }
		 
		 return output;
		 
	 }

}
