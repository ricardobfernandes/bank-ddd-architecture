package com.ricardo.bankddd.application.banking;

import org.springframework.stereotype.Service;

import com.ricardo.bankddd.domain.account.Account;
import com.ricardo.bankddd.domain.account.AccountRepository;

@Service
public class DepositUseCase {
	
    private final AccountRepository accountRepository;

    public DepositUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        account.deposit(amount);
        account.addTransaction("DEPOSIT", amount);
        accountRepository.save(account);
    }
}
