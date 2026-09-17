package com.ricardo.bankddd.interfaces.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.bankddd.application.banking.DepositUseCase;
import com.ricardo.bankddd.application.banking.TransferMoneyUseCase;
import com.ricardo.bankddd.application.banking.WithdrawUseCase;

@RestController
@RequestMapping(value = "/banking")
public class BankingController {

	private final DepositUseCase depositUseCase;
	private final TransferMoneyUseCase transferMoneyUseCase;
	private final WithdrawUseCase withdrawUseCase;

	public BankingController(DepositUseCase depositUseCase, TransferMoneyUseCase transferMoneyUseCase,
			WithdrawUseCase withdrawUseCase) {
		this.depositUseCase = depositUseCase;
		this.transferMoneyUseCase = transferMoneyUseCase;
		this.withdrawUseCase = withdrawUseCase;
	}

	@PostMapping("/{id}/deposit")
	public ResponseEntity<Void> deposit(@PathVariable Long id, @RequestParam Double amount) {
		depositUseCase.execute(id, amount);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/{id}/withdraw")
	public ResponseEntity<Void> withdraw(@PathVariable Long id, @RequestParam Double amount) {
		withdrawUseCase.execute(id, amount);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/{id}/transfer")
	public ResponseEntity<Void> transfer(@PathVariable Long id, @RequestParam Double amount,
			@RequestParam Integer destinationAgency, @RequestParam Integer destinationAccountNumber) {
		transferMoneyUseCase.execute(id, amount, destinationAgency, destinationAccountNumber);
		return ResponseEntity.noContent().build();
	}

}
