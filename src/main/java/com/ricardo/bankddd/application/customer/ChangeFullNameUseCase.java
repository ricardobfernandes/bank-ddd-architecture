package com.ricardo.bankddd.application.customer;

import com.ricardo.bankddd.domain.customer.Customer;
import com.ricardo.bankddd.domain.customer.CustomerRepository;

public class ChangeFullNameUseCase {

    private final CustomerRepository customerRepository;

    public ChangeFullNameUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void execute(Long customerId, String newFullName) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        customer.setFullName(newFullName);
        customerRepository.save(customer);
    }
}
