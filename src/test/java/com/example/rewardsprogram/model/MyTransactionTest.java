package com.example.rewardsprogram.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MyTransactionTest {

	@Test
	void getPoints() {
		MyTransaction myTransaction = new MyTransaction();
		myTransaction.setTotal(120.00);
		assertEquals(myTransaction.getPoints(), 90);
	}

}
