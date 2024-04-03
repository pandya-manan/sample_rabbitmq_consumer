package com.consumer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumer.demo.entity.CustomMessageEntity;

@Repository
public interface CustomMessageRepo extends JpaRepository<CustomMessageEntity,String>{

	public CustomMessageEntity findByMessageId(String messageId);
	
}
