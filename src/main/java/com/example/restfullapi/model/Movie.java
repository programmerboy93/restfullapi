package com.example.restfullapi.model;

import com.example.restfullapi.util.ActorSetSerializer;
import com.example.restfullapi.util.DirectorSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "movies")
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private BigDecimal budget;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate dateOFPremiere;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "roles")
    @JsonSerialize(using = ActorSetSerializer.class)
    private Set<Actor> actors;

    @JsonSerialize(using = DirectorSerializer.class)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Director director;



    public Movie(String title, BigDecimal budget, Set<Actor> actors, Director director, LocalDate dateOFPremiere) {
        this.title = title;
        this.budget = budget;
        this.actors = actors;
        this.director = director;
        this.dateOFPremiere = dateOFPremiere;
    }

    public Movie() {
    }
}
