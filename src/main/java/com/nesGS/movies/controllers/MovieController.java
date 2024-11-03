package com.nesGS.movies.controllers;

import com.nesGS.movies.exceptions.MovieNotFoundException;
import com.nesGS.movies.models.Movie;
import com.nesGS.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")  // Se regula los dominios que pueden acceder ("*" permite cualquiera)
@RestController
@RequestMapping("api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public Iterable<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // El método devuelve una película por su ID. Si no se encuentra, lanza una excepción MovieNotFoundException.
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie with ID " + id + " not found"));
        return ResponseEntity.ok(movie);
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Optional<Movie> savedMovie = movieService.createMovie(movie);
        return savedMovie
                .map(m -> ResponseEntity.status(HttpStatus.CREATED).body(m))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie) {
        Optional<Movie> savedMovie = movieService.updateMovie(id, updatedMovie);

        return savedMovie.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Endpoint para valorar una película de la DB
    @GetMapping("/vote/{id}/{rating}")
    public ResponseEntity<Movie> voteMovie(@PathVariable Long id, @PathVariable double rating) {
        Optional<Movie> ratedMovie = movieService.voteMovie(id, rating);

        return ratedMovie.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}

