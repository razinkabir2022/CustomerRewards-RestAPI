
package com.example.rewardsprogram.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.rewardsprogram.model.Customer;
import com.example.rewardsprogram.repository.CustomerRepository;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest

@AutoConfigureMockMvc
public class CustomerControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CustomerRepository repository;

	@Test
	public void getCustomers() throws Exception {
		Customer customer1 = new Customer(1006, "Tom");
		Customer customer2 = new Customer(1007, "Josa");
		repository.deleteAll();
		repository.save(customer1);
		repository.save(customer2);
		this.mockMvc.perform(get("/v1/customers")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Tom")))
				.andExpect(content().string(containsString("Josa")));
	}
}
