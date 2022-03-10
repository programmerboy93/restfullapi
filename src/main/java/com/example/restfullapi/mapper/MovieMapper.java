package com.example.restfullapi.mapper;

import com.example.restfullapi.model.dto.MovieDto;
import com.example.restfullapi.model.dto.MovieWithoutActorDto;
import com.example.restfullapi.model.entity.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {ActorMapper.class, DirectorMapper.class}, componentModel = "spring")
public interface MovieMapper {

    MovieDto mapToMovieDto(Movie movie);

    List<MovieWithoutActorDto> mapToMovieList(List<Movie> movies);


}
