package com.ricardo.bankddd.application.customer;

import com.ricardo.bankddd.domain.customer.ContactInfo;
import com.ricardo.bankddd.domain.customer.Customer;
import com.ricardo.bankddd.domain.customer.CustomerRepository;

public class ChangeContactInfoUseCase {
	
    private final CustomerRepository customerRepository;

    public ChangeContactInfoUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void execute(Long customerId, ContactInfo newContactInfo) {

        Customer customer = customerRepository.findById(customerId).orElseThrow();
        customer.changeContactInfo(newContactInfo);
        customerRepository.save(customer);
    }
}
