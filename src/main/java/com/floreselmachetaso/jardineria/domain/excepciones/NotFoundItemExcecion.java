package com.floreselmachetaso.jardineria.domain.excepciones;

/**
 * Custom exception class for when an item is not found.
 */
public class NotFoundItemExcecion extends RuntimeException {
    /**
     * Constructs a new NotFoundItemExcecion with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method).
     */
    public NotFoundItemExcecion(String message){
        super(message);
    }
}
