package com.example.restfullapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
@Relation(itemRelation = "director", collectionRelation = "directors")
public class DirectorWithoutMovieDto extends RepresentationModel<DirectorWithoutMovieDto> {
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;
}
