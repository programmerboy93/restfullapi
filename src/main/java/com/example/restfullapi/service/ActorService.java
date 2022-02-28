package com.example.restfullapi.service;

import com.example.restfullapi.model.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    Optional<Actor> get(Long id);

    List<Actor> getAll();

    Actor save(Actor actorWithoutId);
}
