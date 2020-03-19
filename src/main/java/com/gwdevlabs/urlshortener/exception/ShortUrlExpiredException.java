package com.gwdevlabs.urlshortener.exception;

public class ShortUrlExpiredException extends RuntimeException {

    private final String errorMessage;

    public ShortUrlExpiredException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
