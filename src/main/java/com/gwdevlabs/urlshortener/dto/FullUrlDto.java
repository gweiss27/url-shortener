package com.gwdevlabs.urlshortener.dto;

public class FullUrlDto {

    private String fullUrl;

    public FullUrlDto() {}

    public FullUrlDto(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }
}
