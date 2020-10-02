package com.policy.training.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.policy.training.model.Policy;

@Repository
public interface PolicyRepository extends MongoRepository<Policy, String>{
	
	

}
