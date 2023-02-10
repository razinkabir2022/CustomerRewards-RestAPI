package com.example.rewardsprogram.service;

import java.util.Date;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.example.rewardsprogram.model.Customer;
import com.example.rewardsprogram.model.Transaction;
import com.example.rewardsprogram.repository.CustomerRepository;
import com.example.rewardsprogram.repository.TransactionRepository;

public class TransactionServiceTest {

	@InjectMocks
	TransactionService transactionService;

	@Mock
	TransactionRepository transactionRepositoryMock;

	@Mock
	CustomerRepository customerRepositoryMock;

	@BeforeEach
	public void setUp() {

		transactionRepositoryMock = Mockito.mock(TransactionRepository.class);
		customerRepositoryMock = Mockito.mock(CustomerRepository.class);
		transactionService = new TransactionService();
		transactionService.transactionRepository = transactionRepositoryMock;

		transactionService.customerRepository = customerRepositoryMock;

	}

	@Test
	public void createTransaction_Success() {

		Transaction transaction = createTransaction(Long.valueOf(1), Integer.valueOf(5), 151.5, "purchase 1",
				new Date());
		Transaction transactionObject = createTransaction(Long.valueOf(1), Integer.valueOf(5), 151.5, "purchase 1",
				new Date());
		Customer customer = new Customer();
		customer.setId(Integer.valueOf(5));

		Mockito.when(transactionRepositoryMock.save(Mockito.any(Transaction.class))).thenReturn(transactionObject);
		Mockito.when(customerRepositoryMock.findById(Mockito.anyInt())).thenReturn(Optional.of(customer));

		Transaction reward = transactionService.createTransactionById(Integer.valueOf(5), transaction);

		Assert.assertEquals(transaction, reward);

	}

	@Test
	public void updateTransaction_Success() {

		Long id = Long.valueOf(1);

		Transaction transaction = createTransaction(Long.valueOf(1), Integer.valueOf(5), 151.5, "purchase 1",
				new Date());
		Transaction transactionObject = createTransaction(Long.valueOf(1), Integer.valueOf(5), 151.5, "purchase 1",
				new Date());
		Mockito.when(transactionRepositoryMock.findById(id)).thenReturn(Optional.ofNullable(transaction));

		Customer customer = new Customer();
		customer.setId(Integer.valueOf(5));
		Mockito.when(customerRepositoryMock.findById(Mockito.anyInt())).thenReturn(Optional.of(customer));

		Transaction rewardTrans = new Transaction(Long.valueOf(1), customer, 151.5, "purchase 1", new Date());
		Mockito.when(transactionRepositoryMock.save(Mockito.any(Transaction.class))).thenReturn(transactionObject);

		Transaction reward = transactionService.updateTransaction(id, rewardTrans);

		Assert.assertEquals(transactionObject, reward);
	}

	private Transaction createTransaction(Long id, int custId, Double total, String description, Date date) {

		Customer customer = new Customer();
		customer.setId(custId);

		Transaction transactionObject = Transaction.getBuilder(id, customer, total, description, date).build();
		return transactionObject;
	}
}
