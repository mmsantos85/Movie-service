package com.example.DECAMovies;

import com.example.DECAMovies.model.MovieModel;
import com.example.DECAMovies.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

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

    }
}
