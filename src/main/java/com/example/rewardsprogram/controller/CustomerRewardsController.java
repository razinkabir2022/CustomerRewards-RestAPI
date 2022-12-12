package com.example.rewardsprogram.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.rewardsprogram.model.Customer;
import com.example.rewardsprogram.repository.CustomerRepository;
import com.example.rewardsprogram.service.RewardsService;

@RestController
@RequestMapping(value = "/v1")
public class CustomerRewardsController {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	private RewardsService rewardsService;

	@GetMapping("/customers")
	public List<Customer> findCustomerAll() {
		return rewardsService.getCustomerAll();
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
		Customer customer = rewardsService.getCustomerById(id);
		if (customer == null)
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

}
