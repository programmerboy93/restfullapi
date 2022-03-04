package com.example.restfullapi.service.sql;

import com.example.restfullapi.exception.ResourceNotFoundException;
import com.example.restfullapi.model.Actor;
import com.example.restfullapi.repository.ActorRepository;
import com.example.restfullapi.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;

    @Override
    public Actor getActorById(Long id) {
        return actorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public Actor saveActor(Actor saveActor) {
        return actorRepository.save(saveActor);
    }

    @Override
    public void delete(Long id) {
        actorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        actorRepository.deleteById(id);
    }

    @Override
    public Actor update(Long id, String firstName) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        actor.setFirstName(firstName);

        return actorRepository.save(actor);
    }

    @Override
    public Actor updateActor(Long id, Actor updateActor) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(id));

        actor.setDateOfBirth(updateActor.getDateOfBirth());
        actor.setFirstName(updateActor.getFirstName());
        actor.setLastName(updateActor.getLastName());

        return actorRepository.save(actor);
    }
}
