package com.siukee.exception;

public class AnotherException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2772837405375990507L;

	public AnotherException() {
		super();
	}

	public AnotherException(String message) {
		super(message);
	}

	public AnotherException(String message, Throwable cause) {
		super(message, cause);
	}

	public AnotherException(Throwable cause) {
		super(cause);
	}

	protected AnotherException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
