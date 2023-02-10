package com.example.rewardsprogram.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rewardsprogram.model.Customer;
import com.example.rewardsprogram.model.Transaction;

@Service
public class RewardsServiceMock {

	private static List<Transaction> transactions = new ArrayList<Transaction>();
	private static long index;

	static {

		transactions.add(new Transaction(index++, new Customer(1, "Marco"), 100.0, "Purchase 1", new Date()));
		transactions.add(new Transaction(index++, new Customer(2, "Luis"), 50.0, "Purchase 2", new Date()));
		transactions.add(new Transaction(index++, new Customer(3, "Karla"), 120.0, "Purchase 3", new Date()));

	}

	public List<Transaction> getAll() {
		return transactions;
	}

}
