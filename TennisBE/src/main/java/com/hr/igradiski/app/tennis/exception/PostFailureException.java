package com.hr.igradiski.app.tennis.exception;

public class PostFailureException  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PostFailureException(String exception) {
        super(exception);
    }

}
