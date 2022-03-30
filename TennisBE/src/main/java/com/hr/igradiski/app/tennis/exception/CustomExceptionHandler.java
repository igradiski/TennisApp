package com.hr.igradiski.app.tennis.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class CustomExceptionHandler extends  ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ObjectAlreadyExists.class)
    public final ResponseEntity<JsonResponseError> handleObjectAlreadyExist(ObjectAlreadyExists ex, WebRequest request) {
		
		var error = new JsonResponseError(HttpStatus.CONFLICT,ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ObjectNotFound.class)
    public final ResponseEntity<JsonResponseError> objectNotFound(ObjectNotFound ex, WebRequest request){

        var error = new JsonResponseError(HttpStatus.NOT_FOUND,ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(TokenRefreshException.class)
    public final ResponseEntity<JsonResponseError> handleTokenRefreshException(TokenRefreshException ex, WebRequest request) {
		
		var error = new JsonResponseError(HttpStatus.FORBIDDEN,ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }
	
	@ExceptionHandler(PostFailureException.class)
    public final ResponseEntity<JsonResponseError> handlePostFailureException(PostFailureException ex, WebRequest request) {
		
		var error = new JsonResponseError(HttpStatus.CONFLICT,ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
	
	@ExceptionHandler(DeleteFailureException.class)
    public final ResponseEntity<JsonResponseError> handleDeleteFailureException(DeleteFailureException ex, WebRequest request) {
		
		var error = new JsonResponseError(HttpStatus.CONFLICT,ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

}
