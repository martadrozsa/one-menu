package com.denisczwicz.onemenu.infrastructure.config;

import com.denisczwicz.onemenu.domain.exception.BadRequestException;
import com.denisczwicz.onemenu.domain.exception.UserAlreadyExistsException;
import com.denisczwicz.onemenu.domain.exception.UserNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    /**
     * Handles the case when a user is not found.
     * This method is used to return a custom error response when a user cannot be located in the system.
     *
     * @param ex the exception that was thrown
     * @return a ResponseEntity with a 404 status and an error message
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundResponseStatusException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage()));
    }

    /**
     * Handles the case when a bad request is made.
     * This method is used to return a custom error response for bad requests.
     *
     * @param ex the exception that was thrown
     * @return a ResponseEntity with a 400 status and an error message
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestResponseStatusException(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage()));
    }

    /**
     * Handles generic exceptions that are not specifically handled by other methods.
     * This method is used to return a custom error response for any unhandled exceptions.
     *
     * @param ex the exception that was thrown
     * @return a ResponseEntity with a 500 status and an error message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(ex.getMessage()));
    }

    /**
     * Handles the case when a constraint violation occurs.
     * This method is used to return a custom error response when validation constraints are violated.
     *
     * @param ex the exception that was thrown
     * @return a ResponseEntity with a 400 status and a map of validation errors
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(constraintViolation ->
                errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage())
        );
        return ResponseEntity.badRequest().body(errors);
    }

    /**
     * Handles the case when a user already exists.
     * This method is used to return a custom error response when a user already exists in the system.
     *
     * @param ex the exception that was thrown
     * @return a ResponseEntity with a 409 status and an error message
     */
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExists(UserAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(ex.getMessage()));
    }

    /**
     * Handles the case when the request body cannot be parsed.
     * This method is used to return a custom error response when the request body is not readable.
     *
     * @param ex the exception that was thrown
     * @return a ResponseEntity with a 400 status and an error message
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        ex.getMostSpecificCause();
        ex.getMostSpecificCause();
        String message = ex.getMostSpecificCause().getMessage();
        Map<String, String> error = new HashMap<>();
        error.put("error", "Error parsing request body");
        error.put("detail", message);
        return ResponseEntity.badRequest().body(error);
    }

    /**
     * Handles the case when a route is not found.
     * This method is used to return a custom error (404 instead of default 500) response when a route does not exist.
     *
     * @param ex the exception that was thrown
     * @return a ResponseEntity with a 404 status and an error message
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoHandlerFoundException(NoHandlerFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("Route not found: " + ex.getRequestURL()));
    }
}
