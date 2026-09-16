package com.ricardo.bankddd.application.customer;

import com.ricardo.bankddd.domain.customer.Address;
import com.ricardo.bankddd.domain.customer.Customer;
import com.ricardo.bankddd.domain.customer.CustomerRepository;

public class ChangeAddressUseCase {

	private final CustomerRepository customerRepository;

	public ChangeAddressUseCase(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public void execute(Long customerId, Address newAddress) {

		Customer customer = customerRepository.findById(customerId).orElseThrow();
		customer.changeAddress(newAddress);
		customerRepository.save(customer);
	}
}
