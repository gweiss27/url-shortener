package com.gwdevlabs.urlshortener.api.service;

import com.gwdevlabs.urlshortener.api.dto.FullUrlDto;
import com.gwdevlabs.urlshortener.api.dto.ShortUrlDto;
import com.gwdevlabs.urlshortener.api.exception.ShortUrlExpiredException;
import com.gwdevlabs.urlshortener.api.exception.UrlServiceException;
import com.gwdevlabs.urlshortener.api.model.UrlShortModel;
import com.gwdevlabs.urlshortener.api.repository.UrlShortenerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UrlShortenerService.class.getName());

    @Value("${base.serviceUrl}")
    private String BASE_SERVICE_URL;

    @Autowired
    private UrlShortenerRepository urlShortenerRepository;

    @Autowired
    private IdConversionService idConversionService;

    public ShortUrlDto shortenUrl(FullUrlDto fullUrlDto) {

        UrlShortModel model = new UrlShortModel(fullUrlDto.getFullUrl());
        urlShortenerRepository.save(model);

        String shortUrlKey = idConversionService.encode(model.getId());

        model.setShortUrlKey(shortUrlKey);
        model.setTimesUsed(0);
        model.setActive(true);
        urlShortenerRepository.save(model);

        return new ShortUrlDto(BASE_SERVICE_URL + "/gw/" + model.getShortUrlKey());
    }

    public FullUrlDto getFullUrl(String shortUrlKey) {

        LOGGER.info("shortUrlKey:{}", shortUrlKey);

        // Query DB to find object with Hash
        Long id = idConversionService.decode(shortUrlKey);
        UrlShortModel model =
            urlShortenerRepository.findById(id)
                                  .orElseThrow(() -> new UrlServiceException("Full URL not found for provided key [" + shortUrlKey +"]"));

        LOGGER.info("id:{} | fullUrl:{} | shortUrlKey:{} | timesUsed:{}",
                    model.getId(),
                    model.getOriginalUrl(),
                    model.getShortUrlKey(),
                    model.getTimesUsed());

        if (model.getTimesUsed() > 10 || !model.isActive()) {
            throw new ShortUrlExpiredException("This url is no longer valid");
        }

        int timesUsed = model.getTimesUsed() + 1;
        model.setActive(
            timesUsed <= 10
        );
        model.setTimesUsed(timesUsed);
        urlShortenerRepository.save(model);

        return new FullUrlDto(model.getOriginalUrl());
    }
}
