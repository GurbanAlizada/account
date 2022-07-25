package com.example.dto.convertor;

import com.example.dto.TransactionDto;
import com.example.model.Transaction;
import org.springframework.stereotype.Component;



@Component
public class TransactionDtoConvertor {


    public TransactionDto convertToTransactionDto(Transaction transaction){
        return new TransactionDto(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getTransactionType(),
                transaction.getTransactionDate()
        );
    }



}
