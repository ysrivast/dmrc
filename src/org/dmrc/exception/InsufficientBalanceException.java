package org.dmrc.exception;

public class InsufficientBalanceException extends Exception {
	private String message;
	public InsufficientBalanceException(String message) {
		super(message);
		this.message=message;
	}
}
