package org.dmrc.exception;

public class MetroException extends Exception {
	/**
	 * 
	 */
	private String message;
	public MetroException(String message) {
	super(message);
	this.message=message;
	}
}
