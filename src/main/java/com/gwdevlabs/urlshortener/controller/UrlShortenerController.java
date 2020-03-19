package com.gwdevlabs.urlshortener.controller;

import com.gwdevlabs.urlshortener.dto.FullUrlDto;
import com.gwdevlabs.urlshortener.dto.ShortUrlDto;
import com.gwdevlabs.urlshortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
