package com.ricardo.bankddd.application.customer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ricardo.bankddd.domain.customer.Customer;
import com.ricardo.bankddd.domain.customer.CustomerRepository;

@Service
public class FindAllCustomersUseCase {
   
	private final CustomerRepository customerRepository;

    public FindAllCustomersUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> execute() {
        return customerRepository.findAll();
    }

}
