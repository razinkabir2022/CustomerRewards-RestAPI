package com.example.rewardsprogram.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {

	private Customer customer;
	private Set<Transaction> transactions;

	@BeforeEach
	public void setup() {

		transactions = new HashSet<Transaction>();
		customer = new Customer();
		customer.setName("Tom");
		customer.setId(101);
		Transaction transactions1 = new Transaction();
		transactions1.setId(101l);
		transactions1.setDescription("Purchase 1");
		transactions1.setTotal(120.00);
		transactions1.getPoints();
		transactions1.setCustomer(customer);
		transactions1.setSaveDate(new Date());
		Transaction transactions2 = new Transaction();
		transactions2.setId(102l);
		transactions2.setDescription("Purchase 2");
		transactions2.setTotal(120.00);
		transactions2.setSaveDate(new Date());
		transactions2.getPoints();
		transactions2.setCustomer(customer);
		Transaction transactions3 = new Transaction();
		transactions3.setId(103l);
		transactions3.setDescription("Purchase 3");
		transactions3.setTotal(120.00);
		transactions3.setSaveDate(new Date());
		transactions3.getPoints();
		transactions3.setCustomer(customer);
		transactions.add(transactions1);
		transactions.add(transactions2);
		transactions.add(transactions3);
		customer.setTransactions(transactions);

	}

	@Test
	void getRewardPoints() {
		assertEquals(customer.getRewardPoints(), 270);
	}

	@Test
	void getTotalPurchases() {
		assertEquals(customer.getTotalPurchases(), 360);
	}

}
