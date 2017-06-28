package com.neosoft.MyFirstREST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.neosoft.MyFirstREST.exception.DataNotFoundException;
import com.neosoft.MyFirstREST.messages.MessageService;
import com.neosoft.MyFirstREST.model.FilterBean;
import com.neosoft.MyFirstREST.model.Message;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("messages")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	MessageService ms = new MessageService();
	
    
    
   /* @GET
   // @Path("/messagelist")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getmessage(@QueryParam("id") int id,
    								@QueryParam("author") String author)
    {
    	if(id!=0)
    		return ms.getmessagelist(id,author);
    	return ms.getmessagelist();
    }*/
	
	// this method is alternate for above method using BeanParam
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage(@BeanParam FilterBean filterbean)
	{
		if(filterbean.getId()!=0)
			return ms.getmessagelist(filterbean.getId(), filterbean.getAuthor());
		return ms.getmessagelist();
	}
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMessage(Message message,@Context UriInfo uriInfo)
    {
    	Message msg = ms.addMessage(message);
    	String msgId = String.valueOf(msg.getId());
    	return Response.created(uriInfo.getAbsolutePathBuilder().path(msgId).build())
    					.entity(msg)
    					.build();
    	//return "aaya";
    }
    
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getIt(@PathParam("id") long id) 
    {
    	Message message = ms.getMessage(id);
    	if(message==null)
    		throw new DataNotFoundException("Message not found with id = "+id);
        return message;
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("id") long id,Message message)
    {
    	message.setId((int) id);
    	return ms.updateMessage(message);
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Message deleteMessage(@PathParam("id") long id)
    {
    	return ms.deleteMessage(id);
    }
    
    @GET
    @Path("/param")
    public String checkParam(@MatrixParam("matrixParam") String matrix,
    						 @CookieParam("cookieParam") String cookie,
    						 @HeaderParam("headerParam") String header)
    {
    	return "matrix param:"+matrix+" CookieParam:"+cookie+" HeaderParam:"+header;
    }
    
    @GET
    @Path("/contextTest")
    public String checkContext(@Context UriInfo uriInfo,@Context HttpHeaders header)
    {
    	String path = uriInfo.getAbsolutePath().toString();
    	String header1=header.getCookies().toString();
    	return "path="+path+" Cookies="+header1;
    }
    
    @Path("/{id}/comments")
    public MyResource1 getComments()
    {
    	return new MyResource1();
    }
    
    @POST
    @Path("/trail")
    @Produces(MediaType.APPLICATION_JSON)
    public String trial()
    {
    	return "aaya";
    }
    
}
