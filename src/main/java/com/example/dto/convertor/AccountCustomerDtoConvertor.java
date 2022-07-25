package com.example.dto.convertor;

import com.example.dto.AccountCustomerDto;
import com.example.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@AllArgsConstructor
@Component
public class AccountCustomerDtoConvertor {


    public AccountCustomerDto convertToAccountCustomerDto(Customer customer){
        if(customer == null) return new AccountCustomerDto();
        return new AccountCustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getSurname());
    }


}
