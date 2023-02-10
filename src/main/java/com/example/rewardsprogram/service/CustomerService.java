package com.example.rewardsprogram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rewardsprogram.model.Customer;
import com.example.rewardsprogram.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	public CustomerRepository customerRepository;

	/**
	 *
	 * @return - Gets all the Customers in customer table
	 */

	public List<Customer> getCustomerAll() {
		return customerRepository.findAll();
	}

	/**
	 *
	 * @param id - customerID is passed
	 * @return - Customer if present or else null
	 */

	public Customer getCustomerById(Integer customerId) {
		return customerRepository.findById(customerId).orElse(null);
	}

	/**
	 * Create single customer
	 * 
	 * @param customer - Customer object will be passed without custId's
	 * @return - returns customer
	 */
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);

	}

	/**
	 * Create multiple customers
	 * 
	 * @param customers - Customer objects will be passed without custId's
	 * @return - returns list of customers
	 */

	public List<Customer> createCustomers(List<Customer> customers) {
		return customerRepository.saveAll(customers);
	}

	/**
	 * Update customer
	 * 
	 * @param customer - Customer object will be passed without custId's
	 * @return - returns updated customer
	 */
	public Customer updateCustomer(Customer customer) {

		Customer existingcustomer = customerRepository.findById(customer.getId()).orElse(null);

		existingcustomer.setName(customer.getName());

		return customerRepository.save(existingcustomer);

	}

	/**
	 * Delete customer
	 * 
	 * @param customer - CustomerId will be passed
	 * @return - returns no content
	 */
	public void deleteCustomer(int id) {

		customerRepository.deleteById(id);

	}

}
