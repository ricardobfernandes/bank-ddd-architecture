package com.ricardo.bankddd.domain.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.ricardo.bankddd.domain.customer.Customer;
import com.ricardo.bankddd.domain.exceptions.InsufficientFundsException;
import com.ricardo.bankddd.domain.exceptions.InvalidAccountTypeException;
import com.ricardo.bankddd.domain.exceptions.InvalidAmountException;
import com.ricardo.bankddd.domain.transaction.Transaction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_accounts")
public class Account implements Serializable {
	private static final long serialVersionUID = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer agencyNumber;
	private Integer accountNumber;

	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	private Double balance;
	private Double creditLimit;
	private Double interestRate;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<Transaction> transactions = new ArrayList<>();

	public Account() {
	}

	public Account(Long id, Integer agencyNumber, Integer accountNumber, AccountType accountType, Double balance) {
		super();
		this.id = id;
		this.agencyNumber = agencyNumber;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAgencyNumber() {
		return agencyNumber;
	}

	public void setAgencyNumber(Integer agencyNumber) {
		this.agencyNumber = agencyNumber;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Double creditLimit) {
		if (accountType ==  AccountType.SAVINGS_ACCOUNT) {
			 throw new InvalidAccountTypeException("Savings account does not have credit limit.");
		}
		this.creditLimit = creditLimit;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		if (accountType ==  AccountType.CHECKING_ACCOUNT) {
			 throw new InvalidAccountTypeException("Checking account does not have interest rate.");
		}
		this.interestRate = interestRate;
	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
		}
		if (accountType == AccountType.CHECKING_ACCOUNT && amount > this.getBalance() + this.getCreditLimit()) {
		    throw new InsufficientFundsException("Insufficient funds!");
		}
		if (accountType == AccountType.SAVINGS_ACCOUNT && amount > this.getBalance()) {
		    throw new InsufficientFundsException("Insufficient funds!");
		}
		balance -= amount;
	}

	public void deposit(double amount) {
		if (amount <= 0) {
			throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
		}
		balance += amount;
	}

	public void applyInterestRate() {
		balance += balance * interestRate;
	}
	
	public Customer getCustomer() {
	    return customer;
	}

	public void setCustomer(Customer customer) {
	    this.customer = customer;
	}

	public void addTransaction(String type, Double amount) {
		Transaction transaction = new Transaction(type, amount, this);
		transactions.add(transaction);
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(id, other.id);
	}

}
