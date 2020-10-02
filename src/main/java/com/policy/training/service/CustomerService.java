package com.policy.training.service;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.policy.training.model.Customer;

@Service
public class CustomerService {

	public Customer getCustomerDetails(String customerId) {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Customer> response = restTemplate
				.getForEntity("http://localhost:8081/mongoCustomer/" + customerId, Customer.class);
		Customer customer = response.getBody();
		return customer;
	}

	public Customer getCustomerDetailsforObject(String customerId) {

		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.getForObject("http://localhost:8081/mongoCustomer/" + customerId,
				Customer.class);
		return customer;
	}

	public Customer getCustomerDetailsExchange(String customerId) {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Customer> response = restTemplate.exchange("http://localhost:8081/mongoCustomer/" + customerId,
				HttpMethod.GET, requestEntity, Customer.class);
		return response.getBody();
	}

}
