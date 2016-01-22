package com.atlassian.plugins.tutorial.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.atlassian.bamboo.user.BambooUser;
import com.atlassian.bamboo.user.BambooUserManager;


@Path("/user")
public class SimpleUserResource {
	
	BambooUserManager userManager;
	
	public SimpleUserResource(BambooUserManager userManager){
		this.userManager = userManager;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{username}")
	public Response getSimpleUser(@PathParam("username") String username){
		
	   Response response = null;
	   BambooUser bambooUser = userManager.getBambooUser(username);
	   if(bambooUser == null){
		   response = Response.status(Response.Status.NOT_FOUND).entity("Entity not found for username: " + username).build();   
	   } else {
		   response = Response.ok(create(bambooUser)).build();
	   }
	   return response;
    }
	
	public SimpleUser create(BambooUser bambooUser){
		SimpleUser simpleUser = new SimpleUser();
		simpleUser.setEmail(bambooUser.getEmail());
		simpleUser.setName(bambooUser.getName());
		simpleUser.setFullName(bambooUser.getFullName());
		return simpleUser;
	}
}