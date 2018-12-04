package com.qa.service.business;

import java.util.Optional;

import com.qa.persistence.domain.BabyName;

public interface BabyNameService {
	
	String add(String inputName, int nameLength);
	
	Iterable<BabyName> getAllBabyNames();
	
	Optional<BabyName> getBabyName(Long babyId);
	
	String deleteBabyName(Long babyId);
	
	

}
