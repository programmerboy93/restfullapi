package com.example.restfullapi.service.sql;

import com.example.restfullapi.model.entity.Actor;
import com.example.restfullapi.model.entity.Director;
import com.example.restfullapi.model.entity.Movie;
import com.example.restfullapi.repository.ActorRepository;
import com.example.restfullapi.repository.DirectorRepository;
import com.example.restfullapi.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class InitService implements CommandLineRunner {
    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;


    public void initializationDataBaseH2() {

        List<Actor> actors = List.of(
                new Actor("Ana de", "Armas", LocalDate.of(1988, 4, 30))
        );

        Director d1 = new Director("James", "Cameron", LocalDate.of(1954, 8, 16));
        Director d2 = new Director("Steven", "Spielberg", LocalDate.of(1946, 12, 18));

        Actor actor = new Actor("Leonardo", "DiCaprio", LocalDate.of(1974, 11, 11));
        Actor actor1 = new Actor("Kate", "Winslet", LocalDate.of(1975, 10, 5));
        Actor actor2 = new Actor("Sam", "Worthington", LocalDate.of(1976, 8, 2));
        Actor actor3 = new Actor("Zoe", "Saldana", LocalDate.of(1978, 6, 19));


        Movie movie = new Movie("Titanic", BigDecimal.valueOf(2E8), LocalDate.of(1997, 12, 10), List.of(actor1, actor2), d1);
        Movie movie1 = new Movie("Avatar", BigDecimal.valueOf(237E6), LocalDate.of(2009, 11, 1), List.of(actor, actor3, actor1), d1);

        movieRepository.saveAll(List.of(movie1, movie));
        actorRepository.saveAll(actors);
        directorRepository.save(d2);


        log.info("Successful initialization database h2");
    }

    @Override
    public void run(String... args) throws Exception {
        initializationDataBaseH2();
    }
}
