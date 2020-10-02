package com.policy.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policy.training.model.Customer;
import com.policy.training.model.Policy;
import com.policy.training.repository.PolicyRepository;

@Service
public class PolicyService {

	@Autowired
	CustomerService customerService;

	@Autowired
	PolicyRepository policyRepository;

	public Policy createPolicy(Policy policy) {
		Customer customer;
		customer = customerService.getCustomerDetails(policy.getCustomerDetails().getCustomerId());
		policy.setCustomerDetails(customer);
		return policyRepository.save(policy);
	}
	
	public Policy createPolicyForObject(Policy policy) {
		Customer customer;
		customer = customerService.getCustomerDetailsforObject(policy.getCustomerDetails().getCustomerId());
		policy.setCustomerDetails(customer);
		return policyRepository.save(policy);
	}

	public Policy createPolicyExchange(Policy policy) {
		Customer customer;
		customer = customerService.getCustomerDetailsExchange(policy.getCustomerDetails().getCustomerId());
		policy.setCustomerDetails(customer);
		return policyRepository.save(policy);
	}
	public List<Policy> getPolicies() {
		return policyRepository.findAll();
	}

}
