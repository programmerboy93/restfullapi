package com.example.restfullapi.dto;


import com.example.restfullapi.model.Movie;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DirectorDto extends RepresentationModel<DirectorDto> {

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    @JsonIgnoreProperties(value = {"directorDto", "movieDto"})
    private Set<Movie> movies;
}
