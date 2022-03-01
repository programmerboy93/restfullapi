package com.example.restfullapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movies")
@Getter
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private BigDecimal budget;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="roles")
    private Set<Actor> actors;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Director director;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate dateOFPremiere;

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
