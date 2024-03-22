package com.floreselmachetaso.jardineria.domain.excepciones;

/**
 * Class representing an error response for handling exceptions in the application.
 */
public class ErrorResponse {

    private String error; // Type of error
    private String message; // Error message

    /**
     * Get the type of error.
     *
     * @return The type of error.
     */
    public String getError() {
        return error;
    }

    /**
     * Set the type of error.
     *
     * @param error The type of error.
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Get the error message.
     *
     * @return The error message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the error message.
     *
     * @param message The error message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Constructor for the ErrorResponse class.
     *
     * @param error   The type of error.
     * @param message The error message.
     */
    public ErrorResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }
}
