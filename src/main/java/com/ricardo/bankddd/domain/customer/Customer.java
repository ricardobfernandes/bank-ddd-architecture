package com.ricardo.bankddd.domain.customer;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_customer")
public class Customer implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonIgnore
    private String password;
    private String fullName;
    private LocalDate dateOfBirth;
    private String mothersName;
    
	@Enumerated(EnumType.STRING)
	private CustomerGender customerGender;
	
	@Embedded
	private Address address;
	
	@Embedded
	private ContactInfo contactInfo;
	
	public Customer() {
	}

	public Customer(Long id, String password, String fullName, LocalDate dateOfBirth, String mothersName,
			CustomerGender customerGender, Address address, ContactInfo contactInfo) {
		super();
		this.id = id;
		this.password = password;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.mothersName = mothersName;
		this.customerGender = customerGender;
		this.address = address;		
		this.contactInfo = contactInfo;	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMothersName() {
		return mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public CustomerGender getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(CustomerGender customerGender) {
		this.customerGender = customerGender;
	}
	
	public void changeAddress(Address newAddress) {
		this.address = newAddress;
	}
	
	public void changeContactInfo(ContactInfo newContactInfo) {
		this.contactInfo = newContactInfo;
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
		Customer other = (Customer) obj;
		return Objects.equals(id, other.id);
	} 
}
