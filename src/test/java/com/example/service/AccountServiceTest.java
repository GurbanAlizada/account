package com.example.service;

import com.example.dto.AccountDto;
import com.example.dto.CreateAccountRequest;
import com.example.dto.TransactionDto;
import com.example.dto.convertor.AccountDtoConvertor;
import com.example.model.Account;
import com.example.model.Customer;
import com.example.model.Transaction;
import com.example.model.TransactionType;
import com.example.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;


class AccountServiceTest {


    private  AccountRepository accountRepository;
    private  CustomerService customerService;
    private  TransactionService transactionService;
    private  AccountDtoConvertor accountDtoConvertor;
    private AccountService accountService;


    @BeforeEach
    public void setUp(){
        accountRepository = Mockito.mock(AccountRepository.class);
        customerService = Mockito.mock(CustomerService.class);
        transactionService = Mockito.mock(TransactionService.class);
        accountDtoConvertor = Mockito.mock(AccountDtoConvertor.class);
        accountService = new AccountService(accountRepository , customerService , transactionService , accountDtoConvertor);
    }


    @Test
    public void testCreateAccount_whenCustomerIdExistsAndInitialCreditMoreThanZero_shouldCreateAccountWithTransaction(){
        CreateAccountRequest request = new CreateAccountRequest("test-id" , new BigDecimal(200));

        Customer customer = Customer.builder()
                .id(request.getCustomerId())
                .name("test-name")
                .accounts(null)
                .surname("test-surname")
                .build();

        when(customerService.findCustomerById(request.getCustomerId())).thenReturn(customer);

        Account account = new Account("account-id" , request.getInitialCredit() , null , customer);

        Transaction transaction = new Transaction("transaction-id" , request.getInitialCredit() , null , account);


        account.getTransactions().add(transaction);

        TransactionDto transactionDto = new TransactionDto(transaction.getId() , transaction.getAmount() , transaction.getTransactionType() , null);

        AccountDto accountDto = new AccountDto(account.getId() , account.getBalance() , null , null , List.of(transactionDto));

        when(accountRepository.save(account)).thenReturn(account);
        when(accountDtoConvertor.convertToAccountDto(account)).thenReturn(accountDto);

        AccountDto actual = accountService.createAccount(request);

        Assertions.assertEquals(accountDto , actual);


    }






}