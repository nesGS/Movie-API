package com.nesGS.movies.service;

import com.nesGS.movies.models.Movie;

public interface MovieService {

    public Iterable<Movie> getAllMovies();

    public Movie getMovieById(Long id);

    public Movie createMovie(Movie movie);

    public Movie deleteMovie(Movie movie);

    public Movie updateMovie(Movie movie);

    public Movie voteMovie(Movie movie);


}
