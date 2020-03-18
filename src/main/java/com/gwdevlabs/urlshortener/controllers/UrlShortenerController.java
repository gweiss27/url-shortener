package com.gwdevlabs.urlshortener.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class UrlShortenerController {

    @GetMapping("")
    public String helloWorld() {
        return "hello world!";
    }
}
