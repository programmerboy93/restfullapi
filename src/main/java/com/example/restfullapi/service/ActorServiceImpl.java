package com.example.restfullapi.service;

import com.example.restfullapi.exception.ResourceNotFoundException;
import com.example.restfullapi.model.Actor;
import com.example.restfullapi.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;

    @Override
    public Optional<Actor> get(Long id) {
        return actorRepository.findById(id);
    }

    @Override
    public List<Actor> getAll() {
        return actorRepository.findAll();
    }

    @Override
    public Optional<Actor> save(Actor saveActor) {
        return Optional.ofNullable(actorRepository.save(saveActor));
    }

    @Override
    public void delete(Long id) {

        actorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(id));

        actorRepository.deleteById(id);
    }

    @Override
    public Actor update(Long id, String firstName) {

        Actor actor = actorRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException(id));

        actor.setFirstName(firstName);

        return actor;
    }
}
