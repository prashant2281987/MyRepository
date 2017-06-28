package com.neosoft.MyFirstREST.exception;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.neosoft.MyFirstREST.model.ErrorMessage;


@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>
{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		
		ErrorMessage message = new ErrorMessage("Message Not Found",404,"yaha pe sab milega");
		return Response.status(Status.NOT_FOUND)
						.entity(message)
						.build();
	}

}
