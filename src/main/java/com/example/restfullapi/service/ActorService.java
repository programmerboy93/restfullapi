package com.example.restfullapi.service;

import com.example.restfullapi.model.Actor;

import java.util.List;

public interface ActorService {

    Actor getActorById(Long id);

    List<Actor> getAllActors();

    Actor saveActor(Actor actorWithoutId);

    void delete(Long id);

    Actor update(Long id, String firstName);

    Actor updateActor(Long id, Actor editActor);
}
