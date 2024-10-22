package com.nesGS.movies.service;

import com.nesGS.movies.models.Movie;
import com.nesGS.movies.repositories.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImp implements MovieService {

    @Autowired
    private MovieRepository movieRepository;


    @Transactional
    @Override
    public Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public Optional<Movie> createMovie(Movie movie) {
        Movie savedMovie = movieRepository.save(movie);
        return Optional.of(savedMovie);  // Por convención se devuelve el objeto guardado
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Optional<Movie> updateMovie(Long id, Movie updatedMovie) {
        if (!movieRepository.existsById(id)) {
            return Optional.empty(); // Devuelve vacío si no existe la película
        }
        updatedMovie.setId(id);
        Movie savedMovie = movieRepository.save(updatedMovie);
        return Optional.of(savedMovie); // Devuelve la película guardada
    }


    @Override
    public Optional<Movie> voteMovie(Long id, double rating) {
        if (!movieRepository.existsById(id)) {
            return Optional.empty();
        }

        Optional<Movie> optional = movieRepository.findById(id);
        Movie movie = optional.get();

        double newRating = ((movie.getVotes() * movie.getRating()) + rating) / (movie.getVotes() + 1);

        // Actualiza la película y guarda los cambios
        movie.setVotes(movie.getVotes() + 1);
        movie.setRating(newRating);

        Movie savedMovie = movieRepository.save(movie);
        return Optional.of(savedMovie);
    }
}



@Override
public Optional<Movie> voteMovie(Long id, double rating) {
    return movieRepository.findById(id).map(movie -> {
        double newRating = ((movie.getVotes() * movie.getRating()) + rating) / (movie.getVotes() + 1);

        // Actualiza la película y guarda los cambios
        movie.setVotes(movie.getVotes() + 1);
        movie.setRating(newRating);

        Movie savedMovie = movieRepository.save(movie);
        return savedMovie;
    });
}
