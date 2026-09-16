package com.ricardo.bankddd.application.account;

import com.ricardo.bankddd.domain.account.Account;
import com.ricardo.bankddd.domain.account.AccountRepository;

public class CreateAccountUseCase {

	private final AccountRepository accountRepository;

	public CreateAccountUseCase(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public Account execute(Account account) {
		return accountRepository.save(account);
	}
}