package com.gwdevlabs.urlshortener.api.exception;

public class UrlServiceException extends RuntimeException {

    private final String errorMessage;

    public UrlServiceException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
