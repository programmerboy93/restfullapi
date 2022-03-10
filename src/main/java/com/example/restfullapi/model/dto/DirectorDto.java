package com.example.restfullapi.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@Relation(itemRelation = "director",collectionRelation = "directors")
public class DirectorDto extends RepresentationModel<DirectorDto> {

    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private List<MovieWithoutActorDto> movies;
}
