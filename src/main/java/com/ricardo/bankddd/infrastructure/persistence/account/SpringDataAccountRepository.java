package com.ricardo.bankddd.infrastructure.persistence.account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricardo.bankddd.domain.account.Account;

public interface SpringDataAccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByAgencyNumberAndAccountNumber(Integer agencyNumber, Integer accountNumber);
}
