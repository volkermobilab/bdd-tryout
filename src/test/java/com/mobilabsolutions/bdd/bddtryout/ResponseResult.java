package com.mobilabsolutions.bdd.bddtryout;

public class ResponseResult<T> {

	private T responseBody;
	private int statusCode;

	public ResponseResult(T responseBody, int statusCode) {
		super();
		this.responseBody = responseBody;
		this.statusCode = statusCode;
	}

	public T getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(T responseBody) {
		this.responseBody = responseBody;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
