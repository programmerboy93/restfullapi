package com.example.restfullapi.service;

import com.example.restfullapi.model.dto.ActorDto;
import com.example.restfullapi.model.dto.ActorWithoutMoviesDto;
import com.example.restfullapi.model.entity.Actor;

import java.util.List;

public interface ActorService {

    ActorDto getActorById(Long id);

    List<ActorWithoutMoviesDto> getAllActors();

    Actor saveActor(Actor actorWithoutId);

    void delete(Long id);

    Actor update(Long id, String firstName);

    Actor updateActor(Long id, Actor editActor);
}
