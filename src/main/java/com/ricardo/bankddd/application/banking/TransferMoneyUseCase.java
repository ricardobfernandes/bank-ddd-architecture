package com.ricardo.bankddd.application.banking;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.ricardo.bankddd.domain.account.Account;
import com.ricardo.bankddd.domain.account.AccountRepository;
import com.ricardo.bankddd.domain.account.AccountType;
import com.ricardo.bankddd.domain.exceptions.InsufficientFundsException;
import com.ricardo.bankddd.domain.exceptions.InvalidAmountException;
import com.ricardo.bankddd.domain.exceptions.TransferNotAllowedException;

@Service
public class TransferMoneyUseCase {

	private final AccountRepository accountRepository;

	public TransferMoneyUseCase(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public void execute(Long sourceId, Double amount, Integer destinationAgency, Integer destinationAccountNumber) {
		Account accountSource = accountRepository.findById(sourceId).orElseThrow();
		if (amount <= 0) {
			throw new InvalidAmountException("Transfer amount must be greater than zero.");
		}
		if (accountSource.getAccountType() == AccountType.CHECKING_ACCOUNT
				&& amount > accountSource.getBalance() + accountSource.getCreditLimit()) {
			throw new InsufficientFundsException("Insufficient funds!");
		}
		if (accountSource.getAccountType() == AccountType.SAVINGS_ACCOUNT && amount > accountSource.getBalance()) {
			throw new InsufficientFundsException("Insufficient funds!");
		}
		if (amount > 1000) {
			LocalTime now = LocalTime.now();
			if (now.isBefore(LocalTime.of(6, 0)) || now.isAfter(LocalTime.of(22, 0))) {
				throw new TransferNotAllowedException("Transfers above 1000 are only allowed between 06:00 and 22:00!");
			}
		}
		Account accountDestination = accountRepository.findByAgencyNumberAndAccountNumber(destinationAgency, destinationAccountNumber).orElseThrow();
		accountSource.withdraw(amount);
		accountSource.addTransaction("TRANSFER_OUT", -amount);
		accountDestination.deposit(amount);
		accountDestination.addTransaction("TRANSFER_IN", amount);
		accountRepository.save(accountSource);
		accountRepository.save(accountDestination);
	}
}
