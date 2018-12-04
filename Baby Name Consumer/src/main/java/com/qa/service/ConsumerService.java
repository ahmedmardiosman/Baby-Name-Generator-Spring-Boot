package com.qa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.BabyName;
import com.qa.repository.ConsumerRepository;


@Service
public class ConsumerService {

	@Autowired
	private ConsumerRepository consumerRepo;

	public void setRepo(ConsumerRepository persist) {
		this.consumerRepo = persist;
	}

	public Iterable<BabyName> getAll() {
		return consumerRepo.findAll();
	}

	public BabyName add(BabyName babyName) {
		return consumerRepo.save(babyName);
	}

	public void delete(Long Id) {
		consumerRepo.deleteById(Id);
	}

	public Optional<BabyName> get(Long Id) {
		return consumerRepo.findById(Id);
	}
}
