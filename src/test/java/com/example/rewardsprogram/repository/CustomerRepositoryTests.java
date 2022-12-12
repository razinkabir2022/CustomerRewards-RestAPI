package com.example.rewardsprogram.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.rewardsprogram.model.Customer;

@DataJpaTest
public class CustomerRepositoryTests {

	@Autowired
	private CustomerRepository repository;

	@Test
	void saveCustomer() {
		Customer customer = new Customer(1005, "Tom");
		Customer savedCustomer = repository.save(customer);
		assertThat(savedCustomer).isNotNull();
		assertThat(savedCustomer.getId()).isGreaterThan(0);

	}

	@Test
	void deleteAll() {
		Customer customer1 = new Customer(1005, "Tom");
		Customer customer2 = new Customer(1004, "Josa");
		repository.save(customer1);
		repository.save(customer2);
		repository.deleteAll();
		assertThat(repository.findAll()).isEmpty();
	}

	@Test
	void findById() {
		Customer customer = new Customer();
		customer.setName("Tom");
		repository.deleteAll();
		Customer savedCustomer = repository.save(customer);
		assertEquals(savedCustomer.getName(), repository.findById(customer.getId()).get().getName());
	}

	@Test
	void findAll() {
		Customer customer1 = new Customer(1003, "Josa");
		Customer customer2 = new Customer(1004, "Nancy");
		List<Customer> expectedCustomers = new ArrayList<>();
		expectedCustomers.add(customer1);
		expectedCustomers.add(customer2);
		repository.deleteAll();
		repository.save(customer1);
		repository.save(customer2);

		Iterable<Customer> iterable = repository.findAll();
		List<Customer> actualCustomers = new ArrayList<>();
		iterable.forEach(actualCustomers::add);
		assertEquals(expectedCustomers.get(0).getName(), actualCustomers.get(0).getName());
		assertEquals(expectedCustomers.get(1).getName(), actualCustomers.get(1).getName());
	}

	@Test
	void count() {
		Customer customer1 = new Customer(1003, "Tom");
		Customer customer2 = new Customer(1004, "Josa");
		repository.deleteAll();
		repository.save(customer1);
		repository.save(customer2);
		assertEquals(2, repository.count());
	}

}
