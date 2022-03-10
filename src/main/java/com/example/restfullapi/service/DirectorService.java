package com.example.restfullapi.service;


import com.example.restfullapi.model.dto.DirectorDto;
import com.example.restfullapi.model.dto.DirectorWithoutMovieDto;
import com.example.restfullapi.model.entity.Director;

import java.util.List;

public interface DirectorService {

    Director updateDirector(Long id, Director updateDirector);

    DirectorDto getDirectorById(Long id);

    List<DirectorWithoutMovieDto> getAllDirectors();

    Director saveDirector(Director directorWithoutId);

    void deleteDirector(Long id);

    Director updateDirectorFirstName(Long id, String firstName);
}
