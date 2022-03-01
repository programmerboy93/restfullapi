package com.example.restfullapi.service;

import com.example.restfullapi.exception.ResourceNotFoundException;
import com.example.restfullapi.model.Movie;
import com.example.restfullapi.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public Movie saveMovie(Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    @Override
    public Movie updateMovie(Long id, Movie updateMovie) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        movie.setBudget(updateMovie.getBudget());
        movie.setTitle(updateMovie.getTitle());
        movie.setDateOFPremiere(updateMovie.getDateOFPremiere());
        movie.setDirector(updateMovie.getDirector());
        movie.setActors(updateMovie.getActors());

        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(id));

        movieRepository.deleteById(id);
    }

    @Override
    public Movie updateMovieTitle(Long id, String title) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        movie.setTitle(title);

        return movieRepository.save(movie);
    }
}
