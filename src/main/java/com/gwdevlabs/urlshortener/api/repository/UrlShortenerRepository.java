package com.gwdevlabs.urlshortener.api.repository;

import com.gwdevlabs.urlshortener.api.model.UrlShortModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlShortenerRepository extends JpaRepository<UrlShortModel, Long> {

}
