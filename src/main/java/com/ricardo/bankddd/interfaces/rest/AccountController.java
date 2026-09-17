package com.ricardo.bankddd.interfaces.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.bankddd.application.account.CreateAccountUseCase;
import com.ricardo.bankddd.application.account.FindAccountUseCase;
import com.ricardo.bankddd.application.account.FindAllAccountsUseCase;
import com.ricardo.bankddd.domain.account.Account;
import com.ricardo.bankddd.domain.transaction.Transaction;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

	private final CreateAccountUseCase createAccountUseCase;
	private final FindAccountUseCase findAccountUseCase;
	private final FindAllAccountsUseCase findAllAccountsUseCase;

	public AccountController(CreateAccountUseCase createAccountUseCase, FindAccountUseCase findAccountUseCase,
			FindAllAccountsUseCase findAllAccountsUseCase) {
		this.createAccountUseCase = createAccountUseCase;
		this.findAccountUseCase = findAccountUseCase;
		this.findAllAccountsUseCase = findAllAccountsUseCase;
	}

	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account savedAccount = createAccountUseCase.execute(account);
		return ResponseEntity.ok(savedAccount);
	}

	@GetMapping
	public ResponseEntity<List<Account>> findAll() {
		List<Account> accounts = findAllAccountsUseCase.execute();
		return ResponseEntity.ok(accounts);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> findById(@PathVariable Long id) {
		Account account = findAccountUseCase.execute(id);
		return ResponseEntity.ok(account);
	}

	@GetMapping("/info/{id}/balance")
	public ResponseEntity<Double> checkBalance(@PathVariable Long id) {
		Account account = findAccountUseCase.execute(id);
		Double balance = account.getBalance();
		return ResponseEntity.ok().body(balance);
	}

	@GetMapping("/info/{id}/limit")
	public ResponseEntity<Double> checkLimit(@PathVariable Long id) {
		Account account = findAccountUseCase.execute(id);
		Double limit = account.getCreditLimit();
		return ResponseEntity.ok().body(limit);
	}

	@GetMapping("/info/{id}/transactions")
	public ResponseEntity<List<Transaction>> getTransactions(@PathVariable Long id) {
		Account account = findAccountUseCase.execute(id);
		List<Transaction> transactions = account.getTransactions();
		return ResponseEntity.ok().body(transactions);
	}
}
