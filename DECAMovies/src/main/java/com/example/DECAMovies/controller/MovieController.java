package com.example.DECAMovies.controller;


import com.example.DECAMovies.model.MovieModel;
import com.example.DECAMovies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/DECAMovies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("/Discover")
    public ResponseEntity requestMovies(HttpServletRequest request){
        try{
            List<MovieModel> movies = service.movieModelList();
            return new ResponseEntity(movies, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Internal Server Error: No movies found", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
