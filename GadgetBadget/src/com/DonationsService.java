package com;

import model.Donations;

import java.sql.SQLException;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Donations")
public class DonationsService {
	

	Donations DonationsObject = new Donations();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readDonations()
	 {
		return DonationsObject.readDonations();
	 }
	
	
	
	@POST
	@Path("/InsertDonation")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertDonations(@FormParam("name") String name,
	 @FormParam("email") String email,
	 @FormParam("amount") String amount,
	 @FormParam("cardNumber") String cardNumber,
	 @FormParam("CVC") String CVC)
	{
	 String output = DonationsObject.insertDonations(name, email, amount, cardNumber, CVC);
	return output;
	}

	
	
	//Delete donations :
	@POST
	@Path("/Delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public String Delete(@FormParam("donationID") String donationID) throws SQLException
	{
		String output = DonationsObject.deleteDonation(donationID);
		return output;

	}
	
	
	/*@DELETE
	@Path("/DelPostMan")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String donationData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(donationData, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String donationID = doc.select("donationID").text();
	 String output = DonationsObject.deleteItem(donationID);
	return output;
	}*/


}
