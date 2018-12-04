package com.qa.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.BabyName;

@Repository
public interface BabyNameRepository extends JpaRepository<BabyName, Long> {

}
