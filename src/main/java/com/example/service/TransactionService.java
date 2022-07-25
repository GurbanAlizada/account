package com.example.service;

import com.example.model.Account;
import com.example.model.Transaction;
import com.example.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class TransactionService  {

    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    protected Transaction initiateMoney(final Account account , BigDecimal amount){
        return transactionRepository.save(new Transaction(amount , account));
    }








}
