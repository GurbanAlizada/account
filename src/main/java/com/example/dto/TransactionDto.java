package com.example.dto;

import com.example.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {


     private String id;

     private BigDecimal amount;

     private TransactionType transactionType = TransactionType.INITIAL;

      private LocalDateTime transactionDate;

 //   private AccountDto accountDto;



}
