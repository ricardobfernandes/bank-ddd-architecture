package com.ricardo.bankddd.domain.account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {

    Account save(Account account);

    Optional<Account> findById(Long id);

    Optional<Account> findByAgencyNumberAndAccountNumber(Integer agencyNumber, Integer accountNumber);

    List<Account> findAll();
    
    List<Account> saveAll(List<Account> accounts);
    
    boolean existsByCustomerIdAndAccountType(Long customerId, AccountType accountType);
}