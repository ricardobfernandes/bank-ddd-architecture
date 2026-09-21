package com.ricardo.bankddd.application.customer;

import org.springframework.stereotype.Service;

import com.ricardo.bankddd.domain.customer.Customer;
import com.ricardo.bankddd.domain.customer.CustomerRepository;
import com.ricardo.bankddd.domain.exceptions.AccountNotFoundException;
import com.ricardo.bankddd.domain.exceptions.InvalidPasswordTypeException;

@Service
public class ChangePasswordUseCase {

	private final CustomerRepository customerRepository;

	public ChangePasswordUseCase(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public void execute(Long customerId, String newPassword) {
		if (newPassword == null || newPassword.isBlank()) {
			throw new InvalidPasswordTypeException("Password must not be empty.");
		}
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new AccountNotFoundException("Account not found!"));
		customer.setPassword(newPassword);
		customerRepository.save(customer);
	}
}
