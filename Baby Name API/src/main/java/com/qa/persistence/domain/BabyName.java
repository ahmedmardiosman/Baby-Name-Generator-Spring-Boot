package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BabyName {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long babyId;

	private String babyName;
	
	public BabyName() {

	}

	public Long getBabyId() {
		return babyId;
	}

	public void setBabyId(Long babyId) {
		this.babyId = babyId;
	}

	public String getBabyName() {
		return babyName;
	}

	public void setBabyName(String babyName) {
		this.babyName = babyName;
	}

	public String toString() {
		return "BabyNameDetails [babyId =" + babyId + ", babyName=" + babyName + "]";
	}
	
}
