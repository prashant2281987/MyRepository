package com.neosoft.MyFirstREST;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import com.neosoft.MyFirstREST.model.Message;

public class DatabaseContent 
{
	private static NavigableMap<Long, Message> messages = new TreeMap<Long, Message>();
	
	public static NavigableMap<Long, Message> getMessages()
	{
		return messages;
	}
}
