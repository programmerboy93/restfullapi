package com.example.restfullapi.service;

import com.example.restfullapi.model.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    Optional<Actor> get(Long id);

    List<Actor> getAll();

    Optional<Actor> save(Actor actorWithoutId);

    void delete(Long id);

    Actor update(Long id, String firstName);
}
