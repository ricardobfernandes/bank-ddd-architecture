package com.ricardo.bankddd.application.customer;

import org.springframework.stereotype.Service;

import com.ricardo.bankddd.domain.customer.Customer;
import com.ricardo.bankddd.domain.customer.CustomerRepository;

@Service
public class CreateCustomerUseCase {

	private final CustomerRepository customerRepository;

	public CreateCustomerUseCase(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer execute(Customer customer) {
		return customerRepository.save(customer);
	}
}