package com.consumer.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import com.consumer.demo.entity.CustomMessage;
import com.consumer.demo.entity.CustomMessageEntity;
import com.consumer.demo.repository.CustomMessageRepo;

@Service
public class CustomMessageService {
	
	@Autowired
	private CustomMessageRepo repo;

	public CustomMessage getMessageByMessageId(String messageId) throws Exception {
		CustomMessageEntity message=repo.findByMessageId(messageId);
		if(message==null)
		{
			throw new Exception ("There was no message found for the given messageId: "+messageId);
		}
		CustomMessage returnResult=new CustomMessage();
		returnResult.setMessageId(message.getMessageId());
		returnResult.setMessageDate(message.getMessageDate());
		returnResult.setMessage(message.getMessage());
		return returnResult;
	}

	public List<CustomMessage> getAllMessage() throws Exception {
		List<CustomMessageEntity> messages=repo.findAll();
		if(messages.isEmpty() || messages==null)
		{
			throw new Exception("There are no messages in the database");
		}
		List<CustomMessage> returnMessages=new ArrayList<CustomMessage>();
		for(CustomMessageEntity obj:messages)
		{
			CustomMessage messageObject=new CustomMessage(obj.getMessageId(),obj.getMessage(),obj.getMessageDate());
			returnMessages.add(messageObject);
		}
		return returnMessages;
	}
	
	public String saveMessageToDatabase(CustomMessage message) throws Exception
	{
//		repo.insertMessage(message.getMessageId(), message.getMessage(), message.getMessageDate());
		CustomMessageEntity toSave=new CustomMessageEntity();
		toSave.setMessage(message.getMessage());
		toSave.setMessageDate(message.getMessageDate());
		toSave.setMessageId(message.getMessageId());
		repo.save(toSave);
		CustomMessageEntity verification=repo.findByMessageId(message.getMessageId());
		if(verification==null)
		{
			throw new Exception ("The custom message could not be saved to the database");
		}
		
		return "Message saved to database successfully!"+message.getMessageId();
		
		
	}
	
	
	
	

}
