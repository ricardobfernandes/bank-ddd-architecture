package com.ricardo.bankddd.application.account;

import com.ricardo.bankddd.domain.account.Account;
import com.ricardo.bankddd.domain.account.AccountRepository;

public class FindAccountUseCase {

    private final AccountRepository accountRepository;

    public FindAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow();
    }
}
