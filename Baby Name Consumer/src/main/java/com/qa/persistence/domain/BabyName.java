package com.qa.persistence.domain;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	public String getBabyName() {
		return babyName;
	}

	

	public void setBabyId(Long babyId) {
		this.babyId = babyId;
	}

	public void setBabyName(String babyName) {
		this.babyName = babyName;
	}

	@Override
	public String toString() {
		return "PojoAccount [babyId=" + babyId + ", babyName=" + babyName + "]";
	}

}
