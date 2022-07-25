package com.example.dto.convertor;


import com.example.dto.CustomerAccountDto;
import com.example.dto.CustomerDto;
import com.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.stream.Collectors;

@Component
public class CustomerDtoConvertor {

   private final CustomerAccountDtoConvertor customerAccountDtoConvertor;

    public CustomerDtoConvertor(CustomerAccountDtoConvertor customerAccountDtoConvertor) {
        this.customerAccountDtoConvertor = customerAccountDtoConvertor;
    }

    public CustomerDto convertToCustomerDto(Customer customer){
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getSurname(),
                customer.getAccounts().stream()
                        .map(n ->customerAccountDtoConvertor.convertToCustomerAccountDto(n))
                        .collect(Collectors.toList())

        );








    }

}
