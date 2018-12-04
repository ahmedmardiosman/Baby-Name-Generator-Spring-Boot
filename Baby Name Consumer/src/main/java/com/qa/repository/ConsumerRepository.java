package com.qa.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.qa.persistence.domain.BabyName;

@Repository
public interface ConsumerRepository extends MongoRepository<BabyName, Long> {

}
