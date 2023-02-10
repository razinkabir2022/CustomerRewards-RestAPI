package com.example.rewardsprogram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rewardsprogram.model.Transaction;
import com.example.rewardsprogram.repository.TransactionRepository;
import com.example.rewardsprogram.service.TransactionService;

@RestController
@RequestMapping(value = "/v1")
public class TransactionController {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/transaction/{id}")
	public ResponseEntity<Transaction> gettransactions(@PathVariable Long id) {
		Transaction transaction = transactionService.getTransactionId(id);
		if (transaction == null)
			return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}

	@PostMapping("/customer/{id}/transaction")
	public ResponseEntity<Transaction> createTransaction(@PathVariable int id,
			@RequestBody Transaction transactionRequest) {
		if (transactionRequest == null) {
			throw new IllegalArgumentException("transaction object can not be null");
		}
		transactionService.createTransactionById(id, transactionRequest);
		return new ResponseEntity<>(transactionRequest, HttpStatus.CREATED);
	}

	@PutMapping("/transaction/{id}")
	public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
		if (transaction == null) {
			throw new IllegalArgumentException("transaction object can not be null");
		}
		transactionService.updateTransaction(id, transaction);
		return new ResponseEntity<>(transaction, HttpStatus.OK);
	}

	@DeleteMapping("/transaction/{id}")
	public ResponseEntity<HttpStatus> deleteTransaction(@PathVariable Long id) {
		transactionService.deleteTransaction(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
