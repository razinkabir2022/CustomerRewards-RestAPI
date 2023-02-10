package com.example.rewardsprogram.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.example.rewardsprogram.model.Customer;
import com.example.rewardsprogram.repository.CustomerRepository;

public class CustomerServiceTest {

	@InjectMocks
	CustomerService customerService;

	@Mock
	CustomerRepository customerRepositoryMock;

	@BeforeEach
	public void setUp() {

		customerRepositoryMock = Mockito.mock(CustomerRepository.class);
		customerService = new CustomerService();

		customerService.customerRepository = customerRepositoryMock;

	}

	@Test
	public void createCustomer_Success() {

		Customer customer = createDTO("Nag");
		Customer created = createModelObject(Integer.valueOf(5), "Nag");

		Mockito.when(customerRepositoryMock.save(Mockito.any(Customer.class))).thenReturn(created);

		Customer cust = customerService.createCustomer(customer);
		ArgumentCaptor<List> customerArgumentCaptor = ArgumentCaptor.forClass(List.class);
		Mockito.verify(customerRepositoryMock, times(1)).save(customer);
		Assert.assertEquals(created, cust);

	}

	@SuppressWarnings("unchecked")
	@Test
	public void createCustomers_Success() {

		Customer customer = createDTO("Jose");
		Customer created = createModelObject(Integer.valueOf(5), "Jose");

		Mockito.when(customerRepositoryMock.saveAll(Mockito.anyList())).thenReturn(Arrays.asList(created));

		List<Customer> cust = customerService.createCustomers(Arrays.asList(customer));

		ArgumentCaptor<List> customerArgumentCaptor = ArgumentCaptor.forClass(List.class);
		Mockito.verify(customerRepositoryMock, times(1)).saveAll(customerArgumentCaptor.capture());

		Assert.assertEquals(Arrays.asList(created).size(), cust.size());
	}

	@Test
	public void getCustomerById_Success() {
		int id = Integer.valueOf(5);
		Customer created = createModelObject(id, "Hary");
		when(customerRepositoryMock.findById(id)).thenReturn(Optional.of(created));

		Customer cust = customerService.getCustomerById(id);

		verify(customerRepositoryMock, times(1)).findById(id);

		Assert.assertEquals(created, cust);
	}

	@Test
	public void getCustomerAll_Success() {
		int id = Integer.valueOf(5);
		Customer created = createModelObject(id, "Nag");

		Mockito.when(customerRepositoryMock.findAll()).thenReturn(Arrays.asList(created));

		List<Customer> custs = customerService.getCustomerAll();

		verify(customerRepositoryMock, times(1)).findAll();

		Assert.assertEquals(Arrays.asList(created), custs);
	}

	public static Customer createDTO(String name) {
		Customer dto = new Customer();

		// dto.setId(id);
		dto.setName(name);

		return dto;
	}

	public static Customer createModelObject(int id, String name) {
		Customer model = Customer.getBuilder(name).build();

		model.setId(id);

		return model;
	}

}
