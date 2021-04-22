package model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Donations {
	
	private Connection connect()
	 {
		Connection con = null;
		 try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
	
		 //Provide the correct details: DBServer/DBName, username, password
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gadgetbudget?useTimezone=true&serverTimezone=UTC", "root", "");
		 }catch (Exception e){
			 e.printStackTrace();
			 }
		
		 return con;
	} 
	
	
	//insert donations
	public String insertDonations(String name, String email, String amount, String cardNumber,String CVC){
		
		 String output = "";
		 
		 
		 
		 try{
			 Connection con = connect();
			 if (con == null)
			 {
				 return "Error while connecting to the database for inserting.";
			 }
			  
				 
			 // create a prepared statement
			 String query = " insert into donations(`donationID`,`name`,`email`,`amount`,`cardNumber`,`CVC`)"+ " values (?, ?, ?, ?, ?,?)";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			 // binding values
			 preparedStmt.setInt(1, 0);
			 preparedStmt.setString(2, name);
			 preparedStmt.setString(3, email);
			 preparedStmt.setString(4, amount);
			 preparedStmt.setString(5, cardNumber);
			 preparedStmt.setString(6, CVC);
			// execute the statement
			
			 preparedStmt.execute();
			 con.close();
			 output = "Donation is successful";
		 }
		 catch (Exception e)
		 {
			 output = "Error while donating.";
			 System.err.println(e.getMessage());
		 }
		 
		 return output;
	 }
	
	
	

}
