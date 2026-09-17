package com.ricardo.bankddd.interfaces.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.bankddd.application.customer.ChangeAddressUseCase;
import com.ricardo.bankddd.application.customer.ChangeContactInfoUseCase;
import com.ricardo.bankddd.application.customer.ChangeFullNameUseCase;
import com.ricardo.bankddd.application.customer.ChangePasswordUseCase;
import com.ricardo.bankddd.application.customer.CreateCustomerUseCase;
import com.ricardo.bankddd.application.customer.FindAllCustomersUseCase;
import com.ricardo.bankddd.application.customer.FindCustomerUseCase;
import com.ricardo.bankddd.domain.customer.Address;
import com.ricardo.bankddd.domain.customer.ContactInfo;
import com.ricardo.bankddd.domain.customer.Customer;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

	private final ChangeAddressUseCase changeAddressUseCase;
	private final ChangeContactInfoUseCase changeContactInfoUseCase;
	private final ChangeFullNameUseCase changeFullNameUseCase;
	private final ChangePasswordUseCase changePasswordUseCase;
	private final CreateCustomerUseCase createCustomerUseCase;
	private final FindAllCustomersUseCase findAllCustomersUseCase;
	private final FindCustomerUseCase findCustomerUseCase;

	public CustomerController(ChangeAddressUseCase changeAddressUseCase,
			ChangeContactInfoUseCase changeContactInfoUseCase, ChangeFullNameUseCase changeFullNameUseCase,
			ChangePasswordUseCase changePasswordUseCase, CreateCustomerUseCase createCustomerUseCase,
			FindAllCustomersUseCase findAllCustomersUseCase, FindCustomerUseCase findCustomerUseCase) {
		this.changeAddressUseCase = changeAddressUseCase;
		this.changeContactInfoUseCase = changeContactInfoUseCase;
		this.changeFullNameUseCase = changeFullNameUseCase;
		this.changePasswordUseCase = changePasswordUseCase;
		this.createCustomerUseCase = createCustomerUseCase;
		this.findAllCustomersUseCase = findAllCustomersUseCase;
		this.findCustomerUseCase = findCustomerUseCase;
	}

	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = createCustomerUseCase.execute(customer);
		return ResponseEntity.ok(savedCustomer);
	}

	@GetMapping
	public ResponseEntity<List<Customer>> findAll() {
		List<Customer> customers = findAllCustomersUseCase.execute();
		return ResponseEntity.ok(customers);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> findById(@PathVariable Long id) {
		Customer customer = findCustomerUseCase.execute(id);
		return ResponseEntity.ok(customer);
	}

	@PostMapping("/{id}/change-address")
	public ResponseEntity<Void> changeAddress(@PathVariable Long id, @RequestBody Address newAddress) {
		changeAddressUseCase.execute(id, newAddress);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/{id}/change-contacts")
	public ResponseEntity<Void> changeContactInfo(@PathVariable Long id, @RequestBody ContactInfo newContact) {
		changeContactInfoUseCase.execute(id, newContact);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/{id}/change-name")
	public ResponseEntity<Void> changeFullName(@PathVariable Long id, @RequestParam String newFullName) {
		changeFullNameUseCase.execute(id, newFullName);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/{id}/change-password")
	public ResponseEntity<Void> changePassword(@PathVariable Long id, @RequestParam String newPassword) {
		changePasswordUseCase.execute(id, newPassword);
		return ResponseEntity.noContent().build();
	}
}
