package com.ricardo.bankddd.application.customer;

import org.springframework.stereotype.Service;

import com.ricardo.bankddd.domain.customer.Customer;
import com.ricardo.bankddd.domain.customer.CustomerRepository;
import com.ricardo.bankddd.domain.exceptions.AccountNotFoundException;

@Service
public class FindCustomerUseCase {

    private final CustomerRepository customerRepository;

    public FindCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer execute(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new AccountNotFoundException("Account not found!"));
    }
}
