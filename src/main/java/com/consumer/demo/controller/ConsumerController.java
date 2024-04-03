package com.consumer.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.demo.entity.CustomMessage;
import com.consumer.demo.service.CustomMessageService;
import java.util.*;

@RestController
public class ConsumerController {
	
	@Autowired
	private CustomMessageService service;
	
	@GetMapping("/message/{messageId}")
	public CustomMessage getMessageByMessageId(String messageId) throws Exception
	{
		return this.service.getMessageByMessageId(messageId);
	}
	
	@GetMapping("/messages")
	public List<CustomMessage> getAllMessages() throws Exception
	{
		return this.service.getAllMessage();
	}

}
