package com.ricardo.bankddd.application.account;

import java.util.List;
import com.ricardo.bankddd.domain.account.Account;
import com.ricardo.bankddd.domain.account.AccountRepository;

public class FindAllAccountsUseCase {
   
	private final AccountRepository accountRepository;

    public FindAllAccountsUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> execute() {
        return accountRepository.findAll();
    }

}
