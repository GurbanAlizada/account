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
public class CustomerAccountDto {


    private String id;
    private BigDecimal balance = BigDecimal.ZERO;
    private List<TransactionDto> transactionDtoSet;
    private LocalDateTime creationDate;


}
