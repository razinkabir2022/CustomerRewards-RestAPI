package com.example.rewardsprogram.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TransactionTest {

	@Test
	void getPoints() {
		Transaction transaction = new Transaction();
		transaction.setTotal(120.00);
		assertEquals(transaction.getPoints(), 90);
	}

}
