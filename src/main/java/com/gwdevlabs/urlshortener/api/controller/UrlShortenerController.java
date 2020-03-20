package com.gwdevlabs.urlshortener.api.controller;

import com.gwdevlabs.urlshortener.api.dto.FullUrlDto;
import com.gwdevlabs.urlshortener.api.dto.ShortUrlDto;
import com.gwdevlabs.urlshortener.api.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/v1/url")
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @PostMapping("")
    public ShortUrlDto shorten(@RequestBody FullUrlDto fullUrlDto) {
        return urlShortenerService.shortenUrl(fullUrlDto);
    }
}
