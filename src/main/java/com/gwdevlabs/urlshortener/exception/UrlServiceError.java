package com.gwdevlabs.urlshortener.exception;

public class UrlServiceError {

    private String errorMessage;

    public UrlServiceError() {
    }

    public UrlServiceError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
