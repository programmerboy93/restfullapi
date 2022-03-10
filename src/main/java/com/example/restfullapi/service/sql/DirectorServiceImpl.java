package com.example.restfullapi.service.sql;

import com.example.restfullapi.exception.ResourceNotFoundException;
import com.example.restfullapi.mapper.DirectorMapper;
import com.example.restfullapi.model.dto.DirectorDto;
import com.example.restfullapi.model.dto.DirectorWithoutMovieDto;
import com.example.restfullapi.model.entity.Director;
import com.example.restfullapi.repository.DirectorRepository;
import com.example.restfullapi.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;
    private final DirectorMapper directorMapper;

    @Override
    public Director updateDirector(Long id, Director updateDirector) {
        Director director = directorRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(id));

        director.setFirstName(updateDirector.getFirstName());
        director.setLastName(updateDirector.getLastName());
        director.setBirthDate(updateDirector.getBirthDate());

        return directorRepository.save(director);
    }

    @Override
    public DirectorDto getDirectorById(Long id) {
        return directorRepository.findById(id)
                .map(directorMapper::mapToDirectorDto)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public List<DirectorWithoutMovieDto> getAllDirectors() {
        return directorMapper.mapToDirectorDtoList(directorRepository.findAll());
    }

    @Override
    public Director saveDirector(Director directorWithoutId) {
        return directorRepository.save(directorWithoutId);
    }

    @Override
    public void deleteDirector(Long id) {
        directorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        directorRepository.deleteById(id);
    }

    @Override
    public Director updateDirectorFirstName(Long id, String firstName) {
        Director director = directorRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(id));

        director.setFirstName(firstName);

        return directorRepository.save(director);
    }
}
