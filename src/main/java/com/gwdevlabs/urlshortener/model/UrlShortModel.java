package com.gwdevlabs.urlshortener.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "urls")
public class UrlShortModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String originalUrl;
    private String shortUrlKey;
    private int timesUsed;
    private boolean active;

    public UrlShortModel() { }

    public UrlShortModel(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public UrlShortModel(String originalUrl, String shortUrlKey) {
        this.originalUrl = originalUrl;
        this.shortUrlKey = shortUrlKey;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortUrlKey() {
        return shortUrlKey;
    }

    public void setShortUrlKey(String shortUrlKey) {
        this.shortUrlKey = shortUrlKey;
    }

    public int getTimesUsed() {
        return timesUsed;
    }

    public void setTimesUsed(int timesUsed) {
        this.timesUsed = timesUsed;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
