package com.ricardo.bankddd.domain.exceptions;

public class InvalidCustomerNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidCustomerNameException(String message) {
		super(message);
	}

}
