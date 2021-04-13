package com.example.DECAMovies.service;


import com.example.DECAMovies.model.MovieModel;
import com.example.DECAMovies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repo;

    public List<MovieModel> movieModelList() {
        return repo.findAll();
    }

    public Optional<MovieModel> singleMovie(Long id) {
        return repo.findById(id);
    }
}
