package com.neosoft.MyFirstREST.model;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlRootElement;

/*@XmlRootElement
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
*/
public class Message 
{
	private int id;
	private String msg;
	private String author;
	
	public Message()
	{}
	
	public Message(int id, String msg, String author) {
		super();
		this.id = id;
		this.msg = msg;
		this.author = author;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
