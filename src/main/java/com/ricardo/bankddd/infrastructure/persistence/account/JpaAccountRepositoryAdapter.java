package com.ricardo.bankddd.infrastructure.persistence.account;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ricardo.bankddd.domain.account.Account;
import com.ricardo.bankddd.domain.account.AccountRepository;

@Repository
public class JpaAccountRepositoryAdapter implements AccountRepository {

	private final SpringDataAccountRepository repository;

	public JpaAccountRepositoryAdapter(SpringDataAccountRepository repository) {
	    this.repository = repository;
	}

	@Override
	public Optional<Account> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Account save(Account account) {
		return repository.save(account);
	}

	@Override
	public Optional<Account> findByAgencyNumberAndAccountNumber(Integer agencyNumber, Integer accountNumber) {
		return repository.findByAgencyNumberAndAccountNumber(agencyNumber, accountNumber);
	}

	@Override
	public List<Account> findAll() {
		return repository.findAll();
	}
}
