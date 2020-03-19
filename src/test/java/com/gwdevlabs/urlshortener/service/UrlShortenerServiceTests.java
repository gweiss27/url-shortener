package com.gwdevlabs.urlshortener.service;

import com.gwdevlabs.urlshortener.dto.ShortUrlDto;
import com.gwdevlabs.urlshortener.model.UrlShortModel;

public class UrlShortenerServiceTests {

    private UrlShortModel mockReturnFullUrlFromHash(String shortenedUrlHash) {

        // Query DB to find object with Hash
        UrlShortModel model = new UrlShortModel(
            "https://www.youtube.com/playlist?list=PLTjRvDozrdlzBR7lYU4DtQRDQ6xCNSBIS",
            "http://localhost:8080/" + shortenedUrlHash);

        model.setId(1);
        model.setTimesUsed(0);
        model.setActive(true);

        return model;
    }

    private ShortUrlDto mockShortenedUrl() {
        String shortenedUrlHash = "9Az455DX";

        UrlShortModel model = new UrlShortModel(
            "https://www.youtube.com/playlist?list=PLTjRvDozrdlzBR7lYU4DtQRDQ6xCNSBIS",
            "http://localhost:8080/" + shortenedUrlHash);

        return new ShortUrlDto(model.getShortUrlKey());
    }
}
