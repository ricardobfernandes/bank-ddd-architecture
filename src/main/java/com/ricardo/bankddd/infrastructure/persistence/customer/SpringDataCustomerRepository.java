package com.ricardo.bankddd.infrastructure.persistence.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricardo.bankddd.domain.customer.Customer;

public interface SpringDataCustomerRepository extends JpaRepository<Customer, Long>{

}
