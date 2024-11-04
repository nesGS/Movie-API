package com.nesGS.movies.controllers;

import com.nesGS.movies.exceptions.MovieNotFoundException;
import com.nesGS.movies.models.Movie;
import com.nesGS.movies.service.MovieService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")  // Se regula los dominios que pueden acceder ("*" permite cualquiera)
@RestController
@RequestMapping("api/movies")
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);


    @Autowired
    private MovieService movieService;

    //----------------------------------------------------------------

    @GetMapping
    public Iterable<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    //-----------------------------------------------------------------

    // El método devuelve una película por su ID. Si no se encuentra, lanza una excepción MovieNotFoundException.
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@Valid @PathVariable Long id) { //@Valid valida Movie
        Movie movie = movieService.getMovieById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie with ID " + id + " not found"));
        return ResponseEntity.ok(movie);
    }

    //-----------------------------------------------------------------



    // En este caso, se lanza directamente la excepción genérica RuntimeException, y el Controlador
    // CustomResponseEntityExceptionHandler la capturará devolviendo una respuesta HttpStatus.INTERNAL_SERVER_ERROR
    // en el caso de que hubiera algún conflicto con las validaciones o con la DB
    @PostMapping
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody Movie movie) {
        Movie savedMovie = movieService.createMovie(movie)
                .orElseThrow(() -> new RuntimeException("Unexpected error occurred while creating the movie"));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }




    //-----------------------------------------------------------------

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    //-----------------------------------------------------------------

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie) {
        Optional<Movie> savedMovie = movieService.updateMovie(id, updatedMovie);

        return savedMovie.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    //-----------------------------------------------------------------

    // Endpoint para valorar una película de la DB
    @GetMapping("/vote/{id}/{rating}")
    public ResponseEntity<Movie> voteMovie(@PathVariable Long id, @PathVariable double rating) {
        Optional<Movie> ratedMovie = movieService.voteMovie(id, rating);

        return ratedMovie.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}

