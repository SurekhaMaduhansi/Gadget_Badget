package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Products;
import com.ProductsService;

public class addProduct {
	
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

	public String insertItem(String ID,String name, String category, String Description, String quantity,String price, String status)
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
				 String query = " insert into products(`ID`,`name`,`category`,`Description`,`quantity`,`price`,`status`)"
						 + " values (?, ?, ?, ?, ?,? , ?)";
				 
						 PreparedStatement preparedStmt = con.prepareStatement(query);
						
						 // binding values
						 preparedStmt.setInt(1, 0);
						 preparedStmt.setString(2, name);
						 preparedStmt.setString(3, category);
						 preparedStmt.setString(4, Description);
						 preparedStmt.setDouble(5, Integer.parseInt(quantity));
						 preparedStmt.setDouble(6, Double.parseDouble(price));
						 preparedStmt.setString(7, status);
						
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
	
	
	
	
	public String readForm()
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
			 		"            <li><a  href=\"AddProduct.jsp\">Add New Product <i class='fas fa-plus-square'></i></a></li>\r\n" + 
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
			 		"           <br>\r\n" + 
			 		"\r\n" + 
			 		"<body>\r\n" + 
			 		"	\r\n" +  
			 		"			    \r\n" + 
			 		"\r\n" + 
			 		"		<center><div class=\"div1\">\r\n" + 
			 		"		<form action='../../../Products/addProductService/addProduct/AddProduct'  method= \"post\"><br><b>\r\n" + 
			 		"			<div class=\"card\">\r\n" + 
			 		" 				 <img src=\"dd.png\"  style=\"width:50%\">\r\n" + 
			 		"  					<div class=\"container\">\r\n" + 
			 		"  				</div>\r\n" + 
			 		"			</div>\r\n" + 
			 		"			<br><br>\r\n" +
			 		"			<input type=\"hidden\" name=\"ID\">" +
			 		"			Item Name<br> <input type =\"text\" name = \"name\" placeholder = \"Enter the item name..\" required><br><br>\r\n" + 
			 		"			Item Category<br> <input type =\"text\" name = \"category\" placeholder = \"Enter the item category..\" required><br><br>\r\n" + 
			 		"			Item Description<br> <input type =\"text\" name = \"Description\" placeholder = \"Enter the item description..\" required><br><br>\r\n" + 
			 		"			Quantity<br> <input type =\"text\" name = \"quantity\" placeholder = \"Enter the item quantity..\" required><br><br>\r\n" + 
			 		"			Item Price<br> <input type =\"text\" name = \"price\" placeholder = \"Enter the price of the item..\" required><br><br>\r\n" + 
			 		"			Item Activation<br> <select  name = \"status\" required>\r\n" + 
			 		"							<option value = \"\">  </option>\r\n" + 
			 		"							<option value = \"Yes\"> Yes </option>\r\n" + 
			 		"							<option value = \"No\"> No </option>\r\n" + 
			 		"							</select><br><br>\r\n" + 
			 		"			<button class=\"button1\"><span>Add Details </span></button>\r\n" + 
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
	
}
