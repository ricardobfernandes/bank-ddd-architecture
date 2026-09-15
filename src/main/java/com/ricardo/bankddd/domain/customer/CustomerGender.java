package com.ricardo.bankddd.domain.customer;

import com.ricardo.bankddd.domain.exceptions.InvalidCustomerGenderException;

public enum CustomerGender {

	MALE(1), 
	FEMALE(2),
	NON_BINARY(3),
	PREFER_NOT_TO_SAY(4);

	private int code;

	private CustomerGender(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static CustomerGender valueOf(int code) {
		for (CustomerGender value : CustomerGender.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new InvalidCustomerGenderException("Invalid customer gender code");
	}

}
