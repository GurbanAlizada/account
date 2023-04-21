package com.example.service;

import com.example.dto.CustomerDto;
import com.example.dto.convertor.CustomerDtoConvertor;
import com.example.exception.CustomerNotFoundException;
import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

class CustomerServiceTest {



    private  CustomerRepository customerRepository;

    private  CustomerDtoConvertor customerDtoConvertor;

    private CustomerService customerService;


    @BeforeEach
    public void setUp(){
        customerRepository = Mockito.mock(CustomerRepository.class);
        customerDtoConvertor = Mockito.mock(CustomerDtoConvertor.class);
        customerService = new CustomerService(customerRepository , customerDtoConvertor , null);
    }


    @Test
    public void testByCustomerId_whenCustomerByIdExists_shouldReturnCustomer(){

        Customer expected = Customer.builder()
                .id("test-id")
                .name("test-name")
                .build();

        when(customerRepository.findById(expected.getId())).thenReturn(Optional.of(expected));

        Customer actual = customerService.findCustomerById("test-id");
        assertEquals(expected , actual);
    }


    @Test
    public void testByCustomerId_whenCustomerByIdDoesNotExists_shouldThrowCustomerNotFoundException(){

        when(customerRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class , ()-> customerService.findCustomerById(Mockito.anyString()));
    }




    @Test
    public void testgetCustomerById_whenCustomerByIdExists_shouldReturnCustomer(){

        Customer customer = Customer.builder()
                .id("test-id")
                .name("test-name")
                .build();

        CustomerDto expected = new CustomerDto(customer.getId(), customer.getName() , customer.getSurname(), null);

        when(customerRepository.findById(customer.getId())).thenReturn(Optional.of(customer));
        when(customerDtoConvertor.convertToCustomerDto(customer)).thenReturn(expected);


        CustomerDto actual = customerService.getCustomerById(customer.getId());
        assertEquals(expected , actual);

    }


    @Test
    public void testgetCustomerById_whenCustomerByIdDoesNotExists_shouldThrowCustomerNotFoundException(){

        when(customerRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class , ()-> customerService.getCustomerById(Mockito.anyString()));

        verifyNoInteractions(customerDtoConvertor);
    }





}