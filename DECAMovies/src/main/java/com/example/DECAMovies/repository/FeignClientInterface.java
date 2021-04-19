package com.example.DECAMovies.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient (name="DECAMovies", url = "${api.url}")
public interface FeignClientInterface {

    @GetMapping(value = "/discover/movie", produces = "application/json")
    Object discoverMovies(@RequestParam String api_key);

    @GetMapping(value = "/genre/movie/list", produces = "application/json")
    List<Object> listOfGenre();

    @GetMapping(value = "movie/{id}", produces = "application/json")
    Optional<Object> singleMovie(@PathVariable("id") Integer id);

    @GetMapping(value = "/movie/{id}/videos", produces = "application/json")
    Object trailers(@PathVariable Long id);

}

