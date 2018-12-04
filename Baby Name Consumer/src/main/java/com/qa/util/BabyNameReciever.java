package com.qa.util;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.qa.persistence.domain.BabyName;
import com.qa.service.ConsumerService;



@Component
public class BabyNameReciever {
	
	@Autowired
	private ConsumerService service;
	
	@JmsListener(destination = "BabyNamesForMongoDB", containerFactory = "myFactory")
	public void receiveMessage( BabyName babyName) {
		service.add(babyName);
	}
	
	

}
