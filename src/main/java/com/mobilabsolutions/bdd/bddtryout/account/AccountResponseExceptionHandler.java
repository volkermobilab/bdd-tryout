package com.mobilabsolutions.bdd.bddtryout.account;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class AccountResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(HttpStatusException.class)
	public final ResponseEntity<Void> handleUserNotFoundException(HttpStatusException ex, WebRequest request) {
		return new ResponseEntity<>(ex.getHttpStatus());
	}

}
