package com.customer.manage.exception;

public class CustomerNotFound extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CustomerNotFound(String message) {
		super(message);

		/*
		 * @Override public HttpHeaders getResponseHeaders() { // return response
		 * headers }
		 */
	}
}
