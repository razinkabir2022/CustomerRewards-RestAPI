package com.example.rewardsprogram.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.rewardsprogram.model.Customer;
import com.example.rewardsprogram.repository.CustomerRepository;
import com.example.rewardsprogram.service.CustomerService;

@RestController
@RequestMapping(value = "/v1")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> findCustomerAll() {
		return customerService.getCustomerAll();
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
		Customer customer = customerService.getCustomerById(id);
		if (customer == null)
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@PostMapping("/customers")
	public ResponseEntity<?> createCustomers(@RequestBody List<Customer> customers) {
		if (customers == null || customers.size() < 1) {
			throw new IllegalArgumentException("customers objects can not be null");
		}
		customerService.createCustomers(customers);
		return new ResponseEntity<>(customers, HttpStatus.CREATED);
	}

	@PostMapping("/customer")
	public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
		if (customer == null) {
			throw new IllegalArgumentException("customer object can not be null");
		}
		customerService.createCustomer(customer);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}

	@PutMapping("/updateCustomer")
	public Customer updateCustomerSubscription(@RequestBody Customer customer) {
		if (customer == null) {
			throw new IllegalArgumentException("customer object can not be null");
		}
		return customerService.updateCustomer(customer);
	}

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
