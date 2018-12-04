package com.qa.service.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.qa.persistence.domain.BabyName;
import com.qa.util.BabyNameProducer;

@Component
public class APICaller {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${URL.generator.base}" + "${URL.generator.method}")
	private String baseUrl;

	public String getGeneratedBabyName(String inputName, int nameLength) {

		String url = baseUrl + inputName + "/" + nameLength;
		return restTemplate.getForObject(url, String.class);

	}
	
	// JMS

		@Autowired
		private BabyNameProducer producer;

		public void persist(String babyName) {
			producer.produce(babyName);
		}



}
