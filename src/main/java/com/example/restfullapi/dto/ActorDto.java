package com.example.restfullapi.dto;

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
public class ActorDto extends RepresentationModel<ActorDto>{
        private String firstName;

        private String lastName;

        private LocalDate dateOfBirth;

        @JsonIgnoreProperties("actorDto")
        private Set<MovieDto> movies;
}
