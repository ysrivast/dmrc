package org.dmrc.exception;

public class MinimumBalanceException extends Exception{
	private String message;
	public MinimumBalanceException(String message) {
		super(message);
		this.message=message;
	}
}
