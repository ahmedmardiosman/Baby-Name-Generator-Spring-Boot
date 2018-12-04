package com.qa.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.BabyName;
import com.qa.service.business.BabyNameService;


@CrossOrigin
@RequestMapping("${URL.base}")
@RestController
public class BabyNameEndpoints {

	@Autowired
	private BabyNameService service;
	
	@GetMapping("${URL.method.getAllBabyNames}")
	public Iterable<BabyName> getAllBabyNames() {
		return service.getAllBabyNames();
	}
	
	
	@GetMapping("${URL.method.getBabyName}")
	public Optional<BabyName> getBabyName(@PathVariable Long babyId) {
		return service.getBabyName(babyId);
	}
	
	
	@PostMapping("${URL.method.addBabyName}")
	public String addCustomer(@PathVariable("inputName") String inputName,
			@PathVariable("nameLength") int nameLength) {
		return service.add(inputName, nameLength);
		}
	
	@DeleteMapping("${URL.method.deleteBabyName}")
	public String deleteBabyName(@PathVariable Long babyId) {
		return service.deleteBabyName(babyId);
	}
	
	
	
	
	
	
}
