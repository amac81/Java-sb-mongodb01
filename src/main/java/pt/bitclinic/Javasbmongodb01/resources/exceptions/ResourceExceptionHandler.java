package pt.bitclinic.Javasbmongodb01.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import pt.bitclinic.Javasbmongodb01.services.exceptions.ObjectNotFoundException;
import pt.bitclinic.Javasbmongodb01.services.exceptions.DatabaseException;

@ControllerAdvice
public class ResourceExceptionHandler {

	// this method will intercept exceptions of type ResourceNotFoundException and
	// handle them
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;

		StandardError errorBody = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(errorBody);

	}
	
	
	// this method will intercept exceptions of type DatabaseException and
	// handle them
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;

		StandardError errorBody = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(errorBody);
	}
	
}