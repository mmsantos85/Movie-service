package com.example.DECAMovies;

import com.example.DECAMovies.model.MovieModel;
import com.example.DECAMovies.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class MovieRepositoryTest {


    @Autowired
    private MovieRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateMovie(){

        MovieModel movie = new MovieModel();
        movie.setMovieTitle("Dave The Movie");
        movie.setMovieDescription("Dave is a super Hero from the Super Heroes of the Super Heroes Saving the Super Heroes");
        movie.setMovieGenre("SuperHero");

        MovieModel savedMovie = repo.save(movie);
        MovieModel existMovie = entityManager.find(MovieModel.class, savedMovie.getId());

        assertThat(existMovie.getId()).isEqualTo(movie.getId());

    }
}
