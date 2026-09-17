package com.ricardo.bankddd.infrastructure.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ricardo.bankddd.domain.customer.Address;
import com.ricardo.bankddd.domain.customer.ContactInfo;
import com.ricardo.bankddd.domain.customer.Customer;
import com.ricardo.bankddd.domain.customer.CustomerRepository;
import com.ricardo.bankddd.domain.customer.CustomerGender;
import com.ricardo.bankddd.domain.account.Account;
import com.ricardo.bankddd.domain.account.AccountRepository;
import com.ricardo.bankddd.domain.account.AccountType;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    public TestConfig(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }
	
	@Override
	public void run(String... args) throws Exception {

		Address address1 = new Address("Rua Alfa", "1", "", "Biboquinha", "Paraíso", "MG","35000-000","Brasil");
		Address address2 = new Address("Rua Beta", "5", "Bloco B apto 23", "Abba Pai", "Patacá", "MA","12000-000","Brasil");
	    ContactInfo contact1 = new ContactInfo("31911111111", "joaocorrente@teste.com");
	    ContactInfo contact2 = new ContactInfo("31922222222", "mariapoupanca@teste.com");
	    
	    Customer c1 = new Customer(null, "123456", "Joao Silva", LocalDate.of(2002, 9, 24), "Maria Silva", CustomerGender.MALE, address1, contact1);
	    Customer c2 = new Customer(null, "123456", "Maria Suzan Boyle",LocalDate.of(1992, 9, 24), "Lorena Boyle Silva", CustomerGender.FEMALE, address2, contact2);
        customerRepository.saveAll(Arrays.asList(c1, c2));
        
	    Account a1 = new Account(null, 1, 11111, AccountType.CHECKING_ACCOUNT, 1000.0);
	    a1.setCreditLimit(500.0);
	    a1.setCustomer(c1);
	    Account a2 = new Account(null, 1, 22222, AccountType.SAVINGS_ACCOUNT, 2500.0);
	    a2.setInterestRate(0.005);
	    a2.setCustomer(c2);
	    accountRepository.saveAll(Arrays.asList(a1, a2));
	}
}
