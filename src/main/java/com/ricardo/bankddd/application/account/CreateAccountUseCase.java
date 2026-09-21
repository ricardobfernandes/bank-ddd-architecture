package com.ricardo.bankddd.application.account;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ricardo.bankddd.domain.account.Account;
import com.ricardo.bankddd.domain.account.AccountRepository;
import com.ricardo.bankddd.domain.customer.Customer;
import com.ricardo.bankddd.domain.exceptions.AccountAlreadyExistsException;
import com.ricardo.bankddd.domain.exceptions.InvalidAccountTypeException;

@Service
public class CreateAccountUseCase {

    private final AccountRepository accountRepository;

    public CreateAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(Account account) {
        Optional<Account> existingAccount = accountRepository.findByAgencyNumberAndAccountNumber(account.getAgencyNumber(), account.getAccountNumber());
        if (existingAccount.isPresent()) {
            throw new AccountAlreadyExistsException("Account already exists!");
        }
        Customer customer = account.getCustomer();
        boolean alreadyHasSameType = accountRepository.existsByCustomerIdAndAccountType(customer.getId(), account.getAccountType());
        if (alreadyHasSameType) {
            throw new InvalidAccountTypeException("Customer already owns an account of this type.");
        }
        return accountRepository.save(account);
    }
}