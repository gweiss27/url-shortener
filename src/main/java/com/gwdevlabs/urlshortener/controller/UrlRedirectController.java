package com.gwdevlabs.urlshortener.controller;

import com.gwdevlabs.urlshortener.dto.FullUrlDto;
import com.gwdevlabs.urlshortener.service.UrlShortenerService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gw")
public class UrlRedirectController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @GetMapping("/{shortUrlHash}")
    public ResponseEntity<Void> getAndRedirect(@PathVariable("shortUrlHash") String shortUrlHash) {
        FullUrlDto dto = urlShortenerService.getFullUrl(shortUrlHash);
        return ResponseEntity.status(HttpStatus.FOUND)
                             .location(URI.create(dto.getFullUrl()))
                             .build();
    }

}
