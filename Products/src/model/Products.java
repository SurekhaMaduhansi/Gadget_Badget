package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Products {
	
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
	public String insertItem(String name, String category, String Description, String quantity,String price, String status)
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
				 String query = " insert into products(`ID`, `name`, `category`, `Description`, `quantity`, `price`, `status`)" 
				 + " values (?, ?, ?, ?, ?, ?, ?)";
				 
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
					 		"           \r\n" + 
					 		"          \r\n" + 
					 		"					    \r\n" + 
					 		"           <!--table-->\r\n" + 
					 		"		<!-- bootstrap -->\r\n" + 
					 		"	<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n" + 
					 		"	<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n" + 
					 		"	<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n" + 
					 		"<!-- bootstrap -->"+
					 		"<div style=\"color: black; text-align: center; font-size: 22px;\">All Products And Edit Products <i class='fab fa-elementor'></i></div>"+
					 		"<br><center><table border='1' id=\"customers\"><tr><th>Product ID</th><th>Product Name</th>" +
						      "<th>Category</th>" +
						      "<th>Description</th>" +
						      "<th>Quantity</th>" +
						      "<th>Price</th>" +
						      "<th>Status</th>" +
						      "<th>Update Details</th><th>Remove Details</th></tr>";
					 String query = "select * from products";
					 Statement stmt = con.createStatement();
					 ResultSet rs = stmt.executeQuery(query);
					 
					 // iterate through the rows in the result set
						
					 while (rs.next())
					 {
						 String ID = Integer.toString(rs.getInt("ID"));
						 String name = rs.getString("name");
						 String category = rs.getString("category");
						 String Description = rs.getString("Description");
						 String quantity = Integer.toString(rs.getInt("quantity"));
						 String price = Double.toString(rs.getDouble("price"));
						 String status = rs.getString("status");

						 // Add into the html table
						 output += "<tr><td>" + ID + "</td>";
						 output += "<td>" + name + "</td>";
						 output += "<td>" + category + "</td>";
						 output += "<td>" + Description + "</td>";
						 output += "<td>" + quantity + "</td>";
						 output += "<td>" + price + "</td>";
						 output += "<td>" + status + "</td>";
					
						 // buttons
						 output += "<td><button class='button button2'>Update</button></td>"
										 + "<td><form method='post' action='../../../Products/ProductsService/Products/Delete'>"
										 + "<button class='button button3'>Remove</button>"
										 + "<input name='ID' type='hidden' value='" + ID + "'>" + "</form></td></tr>";
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
			 
			 
			public String updateProduct(String ID,String name, String category, String Description, String quantity,String price,String status)
						
			{
				 String output = "";
				
				 try
				 {
					 Connection con = connect();
					 
					 if (con == null)
					 {return "Error while connecting to the database for updating."; }
							
					 // create a prepared statement
							
					 String query = "UPDATE products SET ID=?,name=?,category=?,Description=?,quantity=?,price=?,status=? WHERE ID=?";
					 PreparedStatement preparedStmt = con.prepareStatement(query);
							
					 // binding values
					 preparedStmt.setString(1, name);
					 preparedStmt.setString(2, category);
					 preparedStmt.setString(3, Description);
					 preparedStmt.setInt(4, Integer.parseInt(quantity));
					 preparedStmt.setDouble(5, Double.parseDouble(price));
					 preparedStmt.setString(6, status);
							
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
					
		 public String deleteProduct(String ID)
		{
				 String output = "";
				 try
				 {
					 Connection con = connect();
							
					 if (con == null)
					 {return "Error while connecting to the database for deleting."; }
							
					 // create a prepared statement
					 String query = "delete from products where ID=?";
					 PreparedStatement preparedStmt = con.prepareStatement(query);
						
					 // binding values
					 preparedStmt.setInt(1, Integer.parseInt(ID));
					
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

}
