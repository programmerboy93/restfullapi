package com.example.restfullapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto extends RepresentationModel<MovieDto> {
    private String title;

    private BigDecimal budget;

    private LocalDate dateOFPremiere;

    @JsonIgnoreProperties(value = "moviesDto")
    private Set<ActorDto> actors;

    @JsonIgnoreProperties(value = "moviesDto")
    private DirectorDto directorDto;
}
