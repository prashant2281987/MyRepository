package com.neosoft.MyFirstREST.messages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;

import com.neosoft.MyFirstREST.DatabaseContent;
import com.neosoft.MyFirstREST.model.Message;

public class MessageService 
{
	
	private NavigableMap<Long, Message> messages = DatabaseContent.getMessages();
	
	public MessageService()
	{
		messages.put(1L, new Message(1, "hello world", "SDF"));
		messages.put(2L, new Message(2, "hello world hiiii", "SDF"));
	}
	
	public List<Message> getmessagelist()
	{
		return new ArrayList<Message>(messages.values());
		
	}
	
	public List<Message> getmessagelist(int id,String author)
	{
		List<Message> list = new ArrayList<>();
		Iterator itr = messages.values().iterator();
		while(itr.hasNext())
		{
			Message msg = (Message) itr.next();
			if(msg.getId()>id && msg.getAuthor().equals(author))
				list.add(msg);
		}
		return list;
	}
	
	public Message getMessage(long id)
	{
		return messages.get(id);
	}
	
	public Message addMessage(Message message)
	{
		Message mesg = messages.lastEntry().getValue();
		message.setId(mesg.getId()+1);
		messages.put( (long) message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message)
	{
		
		messages.put((long)message.getId(),message);
		return message;
	}
	
	public Message deleteMessage(long id)
	{
		//Message mesg = messages.get(messages.size()-1);
		messages.remove(id);
		return null;
	}
}
