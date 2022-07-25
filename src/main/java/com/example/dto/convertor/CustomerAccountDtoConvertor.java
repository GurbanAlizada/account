package com.example.dto.convertor;


import com.example.dto.CustomerAccountDto;
import com.example.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConvertor {

    private  final TransactionDtoConvertor transactionDtoConvertor;

    public CustomerAccountDtoConvertor(TransactionDtoConvertor transactionDtoConvertor) {
        this.transactionDtoConvertor = transactionDtoConvertor;
    }

    public CustomerAccountDto convertToCustomerAccountDto(Account account){
        return new CustomerAccountDto(
                account.getId(),
                account.getBalance(),
                account.getTransactions().stream()
                        .map(n->transactionDtoConvertor.convertToTransactionDto(n))
                        .collect(Collectors.toList()),
                account.getCreatitionTime()
        );
    }

}
