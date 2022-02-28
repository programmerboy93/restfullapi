package com.example.restfullapi.contoller;

import com.example.restfullapi.model.Director;
import com.example.restfullapi.repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/directors")
public class DirectorController {

    private final DirectorRepository directorRepository;

    @GetMapping("/{id}")
    public Director getDirector(@PathVariable Long id){
        return directorRepository.findById(id).get();
    }
}
