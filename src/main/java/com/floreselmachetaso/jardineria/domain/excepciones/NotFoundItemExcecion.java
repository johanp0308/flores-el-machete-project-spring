package com.floreselmachetaso.jardineria.domain.excepciones;

public class NotFoundItemExcecion extends RuntimeException {
    public NotFoundItemExcecion(String message){
        super(message);
    }
}
