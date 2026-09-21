package com.ricardo.bankddd.interfaces.rest.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ricardo.bankddd.domain.exceptions.AccountAlreadyExistsException;
import com.ricardo.bankddd.domain.exceptions.AccountNotFoundException;
import com.ricardo.bankddd.domain.exceptions.InsufficientFundsException;
import com.ricardo.bankddd.domain.exceptions.InvalidAccountTypeException;
import com.ricardo.bankddd.domain.exceptions.InvalidAddressException;
import com.ricardo.bankddd.domain.exceptions.InvalidAmountException;
import com.ricardo.bankddd.domain.exceptions.InvalidContactInfoException;
import com.ricardo.bankddd.domain.exceptions.InvalidCustomerGenderException;
import com.ricardo.bankddd.domain.exceptions.InvalidCustomerNameException;
import com.ricardo.bankddd.domain.exceptions.InvalidPasswordTypeException;
import com.ricardo.bankddd.domain.exceptions.TransferNotAllowedException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<StandardError> accountNotFound(AccountNotFoundException e,HttpServletRequest request) {
	    HttpStatus status = HttpStatus.NOT_FOUND;
	    StandardError err = new StandardError(Instant.now(), status.value(),"Account not found",e.getMessage(),request.getRequestURI());
	    return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler({ AccountAlreadyExistsException.class, InsufficientFundsException.class, InvalidAccountTypeException.class, InvalidAddressException.class, InvalidAmountException.class, InvalidContactInfoException.class, InvalidCustomerGenderException.class, InvalidCustomerNameException.class, InvalidPasswordTypeException.class, TransferNotAllowedException.class })
	public ResponseEntity<StandardError> businessException(RuntimeException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), "Business exception", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
  }
}
