package com.qa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.qa.persistence.domain.BabyName;


@Component
public class BabyNameProducer {
	
	private BabyName pojoBabyName = new BabyName();

	@Autowired
	private JmsTemplate jmsTemplate;

	public String produce(String generatedBabyName) {
		pojoBabyName.setBabyName(generatedBabyName);
		jmsTemplate.convertAndSend("BabyNamesForMongoDB", pojoBabyName);
		return "${successful.message}";
	}
}
