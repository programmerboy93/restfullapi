package com.example.restfullapi.service.sql;

import com.example.restfullapi.model.dto.MovieDto;
import com.example.restfullapi.model.dto.MovieWithoutActorDto;
import com.example.restfullapi.exception.ResourceNotFoundException;
import com.example.restfullapi.mapper.MovieMapper;
import com.example.restfullapi.model.entity.Movie;
import com.example.restfullapi.repository.MovieRepository;
import com.example.restfullapi.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieWithoutActorDto> getAllMovies() {
        return movieMapper.mapToMovieList(movieRepository.findAll());
    }

    @Override
    public MovieDto getMovieById(Long id) {
        return movieRepository.findById(id)
                .map(movieMapper::mapToMovieDto)
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
        movie.setPremiereDate(updateMovie.getPremiereDate());
        movie.setDirector(updateMovie.getDirector());

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
