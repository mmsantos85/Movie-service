package com.example.DECAMovies.controller;


import com.example.DECAMovies.model.MovieModel;
import com.example.DECAMovies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/Discover/{id}")
    public ResponseEntity requestSingleProduct(@PathVariable Long id, HttpServletRequest request){
        try{
            Optional<MovieModel> movie = service.singleMovie(id);
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("This movie doesnt exist", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }

    @PutMapping("/Discover")
    public ResponseEntity addMovie(@RequestBody MovieModel newMovieData){
        try{
            MovieModel newMovie = service.addMovie(newMovieData);
            return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity("This request isn't valid", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/Discover/{id}")
    public ResponseEntity deleteMovie(@PathVariable Long id){
        try{
            service.deleteMovie(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("SERVER ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    }
