package com.example.restfullapi.mapper;

import com.example.restfullapi.model.dto.DirectorDto;
import com.example.restfullapi.model.dto.DirectorWithoutMovieDto;
import com.example.restfullapi.model.entity.Director;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {MovieMapper.class}, componentModel = "spring")
public interface DirectorMapper {

    DirectorDto mapToDirectorDto(Director director);

    List<DirectorWithoutMovieDto> mapToDirectorDtoList(List<Director> director);

}
