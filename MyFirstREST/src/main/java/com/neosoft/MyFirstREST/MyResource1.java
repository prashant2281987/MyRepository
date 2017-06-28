package com.neosoft.MyFirstREST;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class MyResource1 
{
	@GET
	public String getComment()
	{
		return "Got the comment";
	}
	
	@GET
	@Path("/{commentId}")
	public String getCommentId(@PathParam("id") int id1, @PathParam("commentId") int id2)
	{
		return "the comment id is "+id2+" Message id is "+id1; 
	}
}
