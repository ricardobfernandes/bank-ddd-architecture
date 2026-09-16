package com.ricardo.bankddd.application.customer;

import com.ricardo.bankddd.domain.customer.Customer;
import com.ricardo.bankddd.domain.customer.CustomerRepository;

public class ChangePasswordUseCase {
	
    private final CustomerRepository customerRepository;

    public ChangePasswordUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void execute(Long customerId, String newPassword) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        customer.setPassword(newPassword);
        customerRepository.save(customer);
    }
}
