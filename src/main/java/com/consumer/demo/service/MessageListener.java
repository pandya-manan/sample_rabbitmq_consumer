package com.consumer.demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.consumer.demo.entity.CustomMessage;
import com.consumer.demo.entity.CustomMessageEntity;
import com.consumer.demo.mqconfig.MQConfig;
import com.consumer.demo.repository.CustomMessageRepo;

@Component
public class MessageListener {
	
	@Autowired
	private CustomMessageRepo repo;
	
	@RabbitListener(queues=MQConfig.QUEUE)
	public void listenMessages(CustomMessage message) throws Exception
	{
		System.out.println(message.toString());
		CustomMessageEntity toSave=new CustomMessageEntity();
		toSave.setMessage(message.getMessage());
		toSave.setMessageDate(message.getMessageDate());
		toSave.setMessageId(message.getMessageId());
		repo.save(toSave);
			
	}

}
