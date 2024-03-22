package com.floreselmachetaso.jardineria.domain.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Global exception handler class to handle exceptions across the application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Exception handler for NotFoundItemException.
     *
     * @param ex The exception to handle.
     * @return ResponseEntity containing the error response and HTTP status.
     */
    @ExceptionHandler(NotFoundItemExcecion.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNotFoundItemException(NotFoundItemExcecion ex) {
        ErrorResponse errorResponse = new ErrorResponse("Item Not Found", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
