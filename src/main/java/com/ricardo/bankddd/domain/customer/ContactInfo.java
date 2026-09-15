package com.ricardo.bankddd.domain.customer;

import jakarta.persistence.Embeddable;

@Embeddable
public class ContactInfo {
	private String phoneNumber; 
	private String email; 
	
	protected ContactInfo() {
	}

	public ContactInfo(String phoneNumber, String email) {
		super();
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}
}
