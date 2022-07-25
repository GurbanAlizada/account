package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {


    private String id;
    private BigDecimal balance ;
    private LocalDateTime creatitionTime;
    private AccountCustomerDto accountCustomerDto;
    private List<TransactionDto> transactionDtoSet;

}
