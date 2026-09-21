package com.ricardo.bankddd.application.customer;

import org.springframework.stereotype.Service;

import com.ricardo.bankddd.domain.customer.Customer;
import com.ricardo.bankddd.domain.customer.CustomerRepository;
import com.ricardo.bankddd.domain.exceptions.AccountNotFoundException;
import com.ricardo.bankddd.domain.exceptions.InvalidCustomerNameException;

@Service
public class ChangeFullNameUseCase {

	private final CustomerRepository customerRepository;

	public ChangeFullNameUseCase(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public void execute(Long customerId, String newFullName) {
		if (newFullName == null || newFullName.isBlank()) {
			throw new InvalidCustomerNameException("Full name must not be empty.");
		}
		String[] parts = newFullName.trim().split("\\s+");
		if (parts.length < 2) {
			throw new InvalidCustomerNameException("Full name must contain first name and last name.");

		}
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new AccountNotFoundException("Account not found!"));
		customer.setFullName(newFullName);
		customerRepository.save(customer);
	}
}
