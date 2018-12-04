package com.qa.service.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.BabyName;
import com.qa.persistence.repository.BabyNameRepository;
import com.qa.service.external.APICaller;

@Service
public class BabyNameServiceImpl implements BabyNameService {
	
	private int len;
	@Autowired
	private BabyNameRepository repo;

	@Autowired
	private APICaller babyNameFromMicroService;
	
	//JMS
	@Autowired
	private APICaller external;

	public String add(String inputName, int nameLength) {
		
		len = inputName.length();
		
		if (inputName.equals("Batman") || inputName.equals("Nutella") || inputName.equals("Rambo")) {

			return  "This name is banned. \nRequest cannot be processed.";

		} else if (nameLength > 12) {

			return "The number of charecters specified is greater than 12. \nRequest cannot be processed.";

		} else if (len > nameLength) {

			return "The number of letters in the name input is longer than that of the input name length.";

		} else {
		BabyName generatedBabyName = new BabyName();
		
		generatedBabyName.setBabyName(babyNameFromMicroService.getGeneratedBabyName(inputName, nameLength));
		
		repo.save(generatedBabyName);
		
		external.persist(generatedBabyName.getBabyName());
		
		return generatedBabyName.getBabyName();
		}
	}

	public Iterable<BabyName> getAllBabyNames() {
	return repo.findAll();
	}

	public Optional<BabyName> getBabyName(Long babyId) {
		return repo.findById(babyId);
	}

	public String deleteBabyName(Long babyId) {
		 repo.deleteById(babyId);
		return "Baby " + babyId + " has been deleted!!!";
	}

}
