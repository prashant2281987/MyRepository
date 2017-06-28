package com.neosoft.MyFirstREST.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.ws.rs.QueryParam;

public class FilterBean 
{
	private @QueryParam("id") int id;
	private @QueryParam("author") String author;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
		
	
}
