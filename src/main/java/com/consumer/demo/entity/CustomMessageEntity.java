package com.consumer.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class CustomMessageEntity {
	
	@Id
	private String messageId;
	
	
	private String message;
	
	
	private String messageDate;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}

	public CustomMessageEntity(String messageId, String message, String messageDate) {
		super();
		this.messageId = messageId;
		this.message = message;
		this.messageDate = messageDate;
	}

	public CustomMessageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
