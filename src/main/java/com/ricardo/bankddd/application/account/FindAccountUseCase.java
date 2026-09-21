package com.ricardo.bankddd.application.account;

import org.springframework.stereotype.Service;

import com.ricardo.bankddd.domain.account.Account;
import com.ricardo.bankddd.domain.account.AccountRepository;
import com.ricardo.bankddd.domain.exceptions.AccountNotFoundException;

@Service
public class FindAccountUseCase {

    private final AccountRepository accountRepository;

    public FindAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException("Account not found!"));
    }
}
