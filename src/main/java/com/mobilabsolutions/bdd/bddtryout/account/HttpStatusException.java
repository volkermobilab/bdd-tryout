package com.mobilabsolutions.bdd.bddtryout.account;

import org.springframework.http.HttpStatus;

public class HttpStatusException extends RuntimeException {

	private static final long serialVersionUID = 5995162625881689530L;

	private HttpStatus httpStatus;

	public HttpStatusException(HttpStatus httpStatus) {
		super();
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
