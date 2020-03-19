package com.gwdevlabs.urlshortener.service;

import org.springframework.stereotype.Service;

@Service
public class IdConversionService {

    private static final String BASE62_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private int BASE = BASE62_ALPHABET.length();


    public String encode(long id) {
        StringBuilder encodedUrlHash = new StringBuilder();
        while (id > 0) {
            int base64index = (int) (id % BASE);
            encodedUrlHash.append(BASE62_ALPHABET.charAt(base64index));
            id = id / BASE;
        }
        return encodedUrlHash.reverse().toString();
    }


    public long decode(String urlHash) {
        long decodedId = 0;
        for (int i = 0; i < urlHash.length(); i++) {
            decodedId = decodedId * BASE + BASE62_ALPHABET.indexOf(urlHash.charAt(i));
        }
        return decodedId;
    }
}
