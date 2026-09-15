package com.ricardo.bankddd.domain.customer;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	private String street; 
	private String number; 
	private String line2; 
	private String neighborhood; 
	private String city; 
	private String state;
	private String zipCode; 
	private String country; 
	
	protected Address() {
	}

	public Address(String street, String number, String line2, String neighborhood, String city, String state,
			String zipCode, String country) {
		super();
		this.street = street;
		this.number = number;
		this.line2 = line2;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public String getNumber() {
		return number;
	}

	public String getLine2() {
		return line2;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCountry() {
		return country;
	}
}
