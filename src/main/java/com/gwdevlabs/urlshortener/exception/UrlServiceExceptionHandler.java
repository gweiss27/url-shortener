package com.gwdevlabs.urlshortener.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UrlServiceExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<UrlServiceError> handleException(HttpServletRequest req, Exception e) {
        return new ResponseEntity<>(new UrlServiceError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UrlServiceException.class)
    public ResponseEntity<UrlServiceError> handleServiceException(HttpServletRequest req, Exception e) {
        return new ResponseEntity<>(new UrlServiceError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ShortUrlExpiredException.class)
    public ResponseEntity<UrlServiceError> handleShortUrlExpiredException(HttpServletRequest req, Exception e) {
        return new ResponseEntity<>(new UrlServiceError(e.getMessage()), HttpStatus.FORBIDDEN);
    }

}
