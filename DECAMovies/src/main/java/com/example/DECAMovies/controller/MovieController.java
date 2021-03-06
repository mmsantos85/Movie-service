package com.example.DECAMovies.controller;


import com.example.DECAMovies.model.MovieModel;
import com.example.DECAMovies.repository.FeignClientInterface;
import com.example.DECAMovies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/DECAMovies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {

    @Autowired
    private MovieService service;

    @Autowired
    private FeignClientInterface feign;

    @GetMapping("/Discover")
    public ResponseEntity requestMovies(HttpServletRequest request){

        try {
            Object discoverMovies = Optional.ofNullable(feign.discoverMovies("54556045cb2a05c4fcbc1a1494d5294a"));
            return new ResponseEntity(discoverMovies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Internal Server Error: No movies found", HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        try{
//            List<MovieModel> movies = service.movieModelList();
//            return new ResponseEntity(movies, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity("Internal Server Error: No movies found", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }

    @GetMapping("/Movie/{id}")
    public ResponseEntity <Object>requestSingleMovie(@PathVariable Integer id, HttpServletRequest request){
        try{
            Optional<Object> movieDetails = feign.singleMovie(id, "54556045cb2a05c4fcbc1a1494d5294a");
            return new ResponseEntity<>(movieDetails.get(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("This movie doesnt exist", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }


    //Movie Trailers
    @GetMapping("/Movie/{id}/videos")
    public ResponseEntity<List<Object>> getMovieTrailers(@PathVariable Integer id, HttpServletRequest request){
        try{
            Object trailersList = feign.trailers(id,"54556045cb2a05c4fcbc1a1494d5294a");
            return new ResponseEntity(trailersList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("This trailer doesnt exist", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Genres")
    public ResponseEntity requestGenre(HttpServletRequest request) {

        try {
            Object genreMovies = Optional.ofNullable(feign.listOfGenre("54556045cb2a05c4fcbc1a1494d5294a"));
            return new ResponseEntity(genreMovies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Internal Server Error: No movies found", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
