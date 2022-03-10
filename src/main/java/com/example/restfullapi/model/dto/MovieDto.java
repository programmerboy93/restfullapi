package com.example.restfullapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@Relation(itemRelation = "movie", collectionRelation = "movies")
public class MovieDto extends RepresentationModel<MovieDto> {
    private Long id;

    private String title;

    private BigDecimal budget;

    private LocalDate premiereDate;

    private DirectorWithoutMovieDto director;

    private List<ActorWithoutMoviesDto> actors;
}
