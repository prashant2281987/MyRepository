package com.neosoft.MyFirstREST.model;

public class ErrorMessage 
{
	private String errorMessage;
	private int statusCode;
	private String resource;
	
	
	
	public ErrorMessage() 
	{
		
	}

	public ErrorMessage(String errorMessage, int statusCode, String resource) {
		super();
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
		this.resource = resource;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	
	
}
