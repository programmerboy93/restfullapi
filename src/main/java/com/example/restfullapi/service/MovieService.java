package com.example.restfullapi.service;

import com.example.restfullapi.model.dto.MovieDto;
import com.example.restfullapi.model.dto.MovieWithoutActorDto;
import com.example.restfullapi.model.entity.Movie;

import java.util.List;

public interface MovieService {
    List<MovieWithoutActorDto> getAllMovies();

    MovieDto getMovieById(Long id);

    Movie saveMovie(Movie newMovie);

    Movie updateMovie(Long id, Movie updateMovie);

    void deleteMovie(Long id);

    Movie updateMovieTitle(Long id, String title);
}
