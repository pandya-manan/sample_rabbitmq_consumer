package com.consumer.demo.entity;

public class CustomMessage {
	
	@Override
	public String toString() {
		return "CustomMessage [messageId=" + messageId + ", message=" + message + ", messageDate=" + messageDate + "]";
	}

	private String messageId;
	
	private String message;
	
	private String messageDate;

	public CustomMessage() {
		super();
		
	}

	public CustomMessage(String messageId, String message, String messageDate) {
		super();
		this.messageId = messageId;
		this.message = message;
		this.messageDate = messageDate;
	}

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
	
	

}
