package com.ricardo.bankddd.application.banking;

import org.springframework.stereotype.Service;

import com.ricardo.bankddd.domain.account.Account;
import com.ricardo.bankddd.domain.account.AccountRepository;
import com.ricardo.bankddd.domain.exceptions.AccountNotFoundException;

@Service
public class DepositUseCase {
	
    private final AccountRepository accountRepository;

    public DepositUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException("Account not found!"));
        account.deposit(amount);
        account.addTransaction("DEPOSIT", amount);
        accountRepository.save(account);
    }
}
