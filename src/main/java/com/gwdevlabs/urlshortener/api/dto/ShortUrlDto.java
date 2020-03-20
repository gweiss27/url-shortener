package com.gwdevlabs.urlshortener.api.dto;

public class ShortUrlDto {

    private String shortUrl;

    public ShortUrlDto(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
