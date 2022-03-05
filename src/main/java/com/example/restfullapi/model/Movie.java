package com.example.restfullapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private BigDecimal budget;

    private LocalDate dateOFPremiere;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "movie")
    private Set<Role> roles;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Director director;

    public Movie(String title, BigDecimal budget, LocalDate dateOFPremiere, Director director) {
        this.title = title;
        this.budget = budget;
        this.dateOFPremiere = dateOFPremiere;
        this.director = director;
    }
}
