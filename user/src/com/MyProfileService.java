package com;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Myprofile;
import model.user;

@Path("/Myprofile")
public class MyProfileService {
	
Myprofile myprofile = new Myprofile(); 
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML)
	public String readUser() 
	{ 
		return myprofile.readMyProfile(); 
	} 
	
	
	@GET
	@Path("/CustomerProfile") 
	@Produces(MediaType.TEXT_HTML)

	public String readCustomerProfile() 
	 {
			
				return myprofile.readCustomerProfile();
			} 
	}



