package com.example.restfullapi.mapper;

import com.example.restfullapi.model.dto.ActorDto;
import com.example.restfullapi.model.dto.ActorWithoutMoviesDto;
import com.example.restfullapi.model.entity.Actor;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {MovieMapper.class}, componentModel = "spring")
public interface ActorMapper {
    @InheritConfiguration
    ActorDto mapToActorDto(Actor actor);

    @InheritConfiguration
    List<ActorWithoutMoviesDto> mapToActorDtoList(List<Actor> actors);

}
