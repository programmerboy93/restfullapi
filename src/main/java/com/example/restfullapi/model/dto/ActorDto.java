package com.example.restfullapi.model.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDate;
import java.util.List;



@Getter
@AllArgsConstructor
@Relation(itemRelation = "actor", collectionRelation = "actors")
@JsonPropertyOrder({"id","firstName","lastName","birthDate","movies"})
public class ActorDto extends RepresentationModel<ActorDto> {
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private List<MovieWithoutActorDto> movies;
}
