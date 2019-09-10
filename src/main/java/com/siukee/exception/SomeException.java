package com.siukee.exception;

public class SomeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7510259297793722992L;

	public SomeException() {
		super();
	}

	public SomeException(String message) {
		super(message);
	}

	public SomeException(String message, Throwable cause) {
		super(message, cause);
	}

	public SomeException(Throwable cause) {
		super(cause);
	}

	protected SomeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
