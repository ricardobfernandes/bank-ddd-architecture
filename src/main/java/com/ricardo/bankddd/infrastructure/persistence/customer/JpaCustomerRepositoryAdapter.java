package com.ricardo.bankddd.infrastructure.persistence.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ricardo.bankddd.domain.customer.Customer;
import com.ricardo.bankddd.domain.customer.CustomerRepository;

@Repository
public class JpaCustomerRepositoryAdapter implements CustomerRepository{

	private final SpringDataCustomerRepository repository;

	public JpaCustomerRepositoryAdapter(SpringDataCustomerRepository repository) {
	    this.repository = repository;
	}
	
	@Override
	public Customer save(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Customer> findAll() {
		return repository.findAll() ;
	}
	
	

}
