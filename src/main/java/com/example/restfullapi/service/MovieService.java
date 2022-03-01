package com.example.restfullapi.service;

import com.example.restfullapi.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovieById(Long id);

    Movie saveMovie(Movie newMovie);

    Movie updateMovie(Long id, Movie updateMovie);

    void deleteMovie(Long id);

    Movie updateMovieTitle(Long id, String title);
}
