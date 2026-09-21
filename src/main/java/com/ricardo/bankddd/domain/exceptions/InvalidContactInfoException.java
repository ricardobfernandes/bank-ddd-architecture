package com.ricardo.bankddd.domain.exceptions;

public class InvalidContactInfoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidContactInfoException(String message) {
		super(message);
	}

}
