package com.ricardo.bankddd.application.banking;

import com.ricardo.bankddd.domain.account.Account;
import com.ricardo.bankddd.domain.account.AccountRepository;

public class WithdrawUseCase {
	
    private final AccountRepository accountRepository;

    public WithdrawUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        account.withdraw(amount);
        account.addTransaction("WITHDRAW", amount);
        accountRepository.save(account);
    }
}
