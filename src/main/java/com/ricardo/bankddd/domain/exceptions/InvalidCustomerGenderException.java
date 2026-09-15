package com.ricardo.bankddd.domain.exceptions;

public class InvalidCustomerGenderException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidCustomerGenderException(String message) {
		super(message);
	}
}
