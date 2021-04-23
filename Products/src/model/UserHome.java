package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.core.Request;

public class UserHome {
	
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
			

		public String insertCart(String email,int ID,int quantity,String price)
		 {
			 String output = "";
			 	int product_price = 0;
				int product_total = 0;
				int cart_total = 0;
				int quantity1 = 1;
				
				
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
						quantity1=rs1.getInt(3);
						quantity1=quantity1+1;
						z=1;
					}
					if(z == 1 )
					{
						st.executeUpdate("update carts set total ='"+cart_total+"',quantity='"+quantity+"' where ID='"+ID+"' and email ='"+email+"' and address is null");
						
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
		
		
		
			 public String readAllProduct()
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
					 		"					    	<button type = \"Submit\">Search</button>\r\n" + 
					 		"					    \r\n" + 
					 		"					    </form>\r\n" + 
					 		"               \r\n" + 
					 		"             \r\n" + 
					 		"            </div>\r\n" + 
					 		"          </div>\r\n" + 
					 		"           <br>\r\n" + 
					 		"           <!--table-->\r\n" + 
					 		""
					 		+ "<center><table border='1'><tr><th>Product ID</th><th>Product Name</th>" +
						      "<th>Category</th>" +
						      "<th>Description</th>" +
						      "<th>Price</th>" +
						      "<th>Add To Cart</th></tr>";
					 
					 String query = "Select * from products where status = 'Yes'";
					 Statement stmt = con.createStatement();
					 ResultSet rs = stmt.executeQuery(query);
					 
					 // iterate through the rows in the result set
						
					 while (rs.next())
					 {
						 String ID = Integer.toString(rs.getInt("ID"));
						 String name = rs.getString("name");
						 String category = rs.getString("category");
						 String Description = rs.getString("Description");
						 String price = Double.toString(rs.getDouble("price"));


						 // Add into the html table
						 output += "<tr><td>" + ID + "</td>";
						 output += "<td>" + name + "</td>";
						 output += "<td>" + category + "</td>";
						 output += "<td>" + Description + "</td>";
						 output += "<td>" + price + "</td>";

					
						 // buttons
						 output += "<td><form method='post' action='../../../Products/UserHomeService/AllProducts/AddCart'>"
										 + "<button class='button button2'>Add To Cart</button>"
										 + "<input name='email' type='hidden' value='sa@gmail.com'>" 
										 + "<input name='ID' type='hidden' value='"+ID+"'>" 
										 + "<input name='price' type='hidden' value='"+price+"'>"  
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
