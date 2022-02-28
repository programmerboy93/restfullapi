package com.example.restfullapi.service;

import com.example.restfullapi.model.Actor;
import com.example.restfullapi.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService{
    private final ActorRepository actorRepository;

    @Override
    public Optional<Actor> get(Long id){
        return actorRepository.findById(id);
    }

    @Override
    public List<Actor> getAll() {
        return actorRepository.findAll();
    }

    @Override
    public Optional<Actor> save(Actor actorWithoutId) {
        return Optional.ofNullable(actorRepository.save(actorWithoutId));
    }
}
