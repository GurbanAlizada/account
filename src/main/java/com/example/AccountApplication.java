package com.example;

import com.example.exception.RestTemplateResponseErrorHandler;
import com.example.model.Customer;
import com.example.repository.AccountRepository;
import com.example.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@SpringBootApplication
public class AccountApplication  implements CommandLineRunner {


    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final RestTemplateResponseErrorHandler restTemplateResponseErrorHandler;

    public AccountApplication(AccountRepository accountRepository, CustomerRepository customerRepository, RestTemplateResponseErrorHandler restTemplateResponseErrorHandler) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.restTemplateResponseErrorHandler = restTemplateResponseErrorHandler;
    }


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder().errorHandler(restTemplateResponseErrorHandler).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        Customer customer = customerRepository.save(new Customer(null , "Messi" ,"Leo" , new ArrayList<>()));
        System.out.println(customer);
    }


}
