package com.floreselmachetaso.jardineria.domain.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalHandlerExpceciones {
    
    @ExceptionHandler(NotFoundItemExcecion.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNotFoundItemExcecion(NotFoundItemExcecion ex){
        ErrorResponse errorResponse = new ErrorResponse("No se encontro Item", ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
        
    }

}
