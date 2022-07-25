package com.example.service;

import com.example.dto.AccountCustomerDto;
import com.example.dto.CustomerDto;
import com.example.dto.convertor.AccountCustomerDtoConvertor;
import com.example.dto.convertor.CustomerDtoConvertor;
import com.example.exception.CustomerNotFoundException;
import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerService  {


    private final CustomerRepository customerRepository;
    private final CustomerDtoConvertor customerDtoConvertor;
    private final ModelMapper modelMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConvertor customerDtoConvertor , ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.customerDtoConvertor = customerDtoConvertor;
        this.modelMapper = modelMapper;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(
                        ()-> new CustomerNotFoundException("Kullanici Bulunamadi : " +id));
    }


    public CustomerDto getCustomerById(String customerId) {
       //  return modelMapper.map(findCustomerById(customerId) , CustomerDto.class);
       return customerDtoConvertor.convertToCustomerDto(findCustomerById(customerId));
    }


}
