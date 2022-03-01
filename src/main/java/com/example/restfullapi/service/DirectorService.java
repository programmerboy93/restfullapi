package com.example.restfullapi.service;


import com.example.restfullapi.model.Director;

import java.util.List;

public interface DirectorService {

    Director updateDirector(Long id,Director updateDirector);

    Director getDirectorById(Long id);

    List<Director> getAllDirectors();

    Director saveDirector(Director directorWithoutId);

    void deleteDirector(Long id);

    Director updateDirectorFirstName(Long id, String firstName);
}
