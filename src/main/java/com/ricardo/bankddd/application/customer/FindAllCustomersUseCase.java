package com.ricardo.bankddd.application.customer;

import java.util.List;
import com.ricardo.bankddd.domain.customer.Customer;
import com.ricardo.bankddd.domain.customer.CustomerRepository;

public class FindAllCustomersUseCase {
   
	private final CustomerRepository customerRepository;

    public FindAllCustomersUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> execute() {
        return customerRepository.findAll();
    }

}
