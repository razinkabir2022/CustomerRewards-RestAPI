package com.example.rewardsprogram.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rewardsprogram.model.Transaction;
import com.example.rewardsprogram.repository.CustomerRepository;
import com.example.rewardsprogram.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	CustomerRepository customerRepository;

	/**
	 * This method get transaction .
	 * 
	 * @param TransactionID will be passed
	 * @return - Transaction with TransactionID
	 */
	public Transaction getTransactionId(Long TransactionId) {
		return transactionRepository.findById(TransactionId).orElse(null);
	}

	/**
	 * This method accepts only single transaction
	 * 
	 * @param CustomerID will be passed
	 * @param Single     transaction object will be passed
	 * @return - Newly created transaction record will be returned
	 */
	public Transaction createTransactionById(int id, Transaction transactionRequest) {

		Transaction transaction = customerRepository.findById(id).map(customer -> {
			transactionRequest.setCustomer(customer);
			return transactionRepository.save(transactionRequest);
		}).orElseThrow(() -> new EntityNotFoundException("Not found Customer with id = " + id));
		return transactionRequest;
	}

	/**
	 * This method updates transaction .
	 * 
	 * @param TransactionID will be passed
	 * @param Transaction   that needs to be updated
	 * @return - Updated transaction record will be returned
	 */
	public Transaction updateTransaction(Long id, Transaction transactionRequest) {

		Transaction existingTransaction = transactionRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Not found Transaction with id = " + id));
		existingTransaction.setDescription(transactionRequest.getDescription());
		existingTransaction.setTotal(transactionRequest.getTotal());
		existingTransaction.setSaveDate(transactionRequest.getSaveDate());
		return transactionRepository.save(existingTransaction);
	}

	/**
	 * This method delete transaction .
	 * 
	 * @param TransactionID will be passed
	 * @return - No content
	 */
	public void deleteTransaction(Long id) {

		transactionRepository.deleteById(id);

	}

}
