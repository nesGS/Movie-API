package com.nesGS.movies.service;

import com.nesGS.movies.models.Movie;
import com.nesGS.movies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImp implements MovieService {

    @Autowired
    private MovieRepository movieRepo;

    @Override
    public Iterable<Movie> getAllMovies() {
        return null;
    }

    @Override
    public Movie getMovieById(Long id) {
        return null;
    }

    @Override
    public Movie createMovie(Movie movie) {
        return null;
    }

    @Override
    public Movie deleteMovie(Movie movie) {
        return null;
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return null;
    }

    @Override
    public Movie voteMovie(Movie movie) {
        return null;
    }
}
