package com.ricardo.bankddd.domain.exceptions;

public class InvalidPasswordTypeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidPasswordTypeException(String message) {
		super(message);
	}

}
