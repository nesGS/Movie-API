package com.nesGS.movies.service;

import com.nesGS.movies.models.Movie;

import java.util.Optional;

public interface MovieService {

    public Iterable<Movie> getAllMovies();

    public Optional<Movie> getMovieById(Long id);

    public Optional<Movie> createMovie(Movie movie);

    public void deleteMovie(Long id);

    public Optional<Movie> updateMovie(Long id, Movie updatedMovie);

    public Optional<Movie> voteMovie(Long id, double rating);


}
