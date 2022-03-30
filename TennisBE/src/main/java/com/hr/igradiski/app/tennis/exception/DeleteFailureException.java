package com.hr.igradiski.app.tennis.exception;

public class DeleteFailureException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DeleteFailureException(String exception) {
        super(exception);
    }

}
