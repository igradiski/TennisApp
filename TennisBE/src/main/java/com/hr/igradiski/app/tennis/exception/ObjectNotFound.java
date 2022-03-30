package com.hr.igradiski.app.tennis.exception;

public class ObjectNotFound  extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ObjectNotFound(String exception) {
        super(exception);
    }
}
