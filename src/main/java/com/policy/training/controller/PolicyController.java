package com.policy.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.policy.training.model.Policy;
import com.policy.training.service.PolicyService;

@RestController
public class PolicyController {

	@GetMapping("/hello")
	public String hello() {
		return "Hey There ROHIT";
	}

	@Autowired
	private PolicyService policyService;

	@PostMapping("/policy")
	public Policy createPolicy(@RequestBody Policy policy) {
		return policyService.createPolicy(policy);
	}

	@PostMapping("/policyExchange")
	public Policy createPolicyExchange(@RequestBody Policy policy) {
		return policyService.createPolicyExchange(policy);
	}

	@PostMapping("/policyForObject")
	public Policy createPolicyForObject(@RequestBody Policy policy) {
		return policyService.createPolicyForObject(policy);
	}

	@GetMapping("/policy")
	public List<Policy> getPolocies() {
		return policyService.getPolicies();
	}

}
