package com.example.restfullapi.contoller;

import com.example.restfullapi.model.dto.ActorWithoutMoviesDto;
import com.example.restfullapi.model.dto.MovieDto;
import com.example.restfullapi.model.dto.MovieWithoutActorDto;
import com.example.restfullapi.model.entity.Movie;
import com.example.restfullapi.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CollectionModel<MovieWithoutActorDto>> getAllMovies() {
        List<MovieWithoutActorDto> movies = movieService.getAllMovies().stream()
                .map(a -> a.add(linkTo(methodOn(MovieController.class).getMovie(a.getId())).withRel("moviesActor")))
                .collect(Collectors.toList());

        Link link = linkTo(methodOn(MovieController.class).getAllMovies()).withSelfRel();
        return ResponseEntity.ok(new CollectionModel<>(movies, link));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable Long id) {
        MovieDto movie = movieService.getMovieById(id);
        movie.add(linkTo(methodOn(MovieController.class).getMovie(movie.getId())).withSelfRel());
        movie.add(linkTo(methodOn(MovieController.class).getAllMovies()).withRel("movies"));
        movie.getDirector().add(linkTo(methodOn(DirectorController.class).getDirector(movie.getDirector().getId())).withRel("director"));
        for (ActorWithoutMoviesDto actor : movie.getActors()) {
            actor.add(linkTo(methodOn(ActorController.class).getActor(actor.getId())).withRel("actor"));
        }

        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie newMovie) {
        return new ResponseEntity<>(movieService.saveMovie(newMovie), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") Long id,
                                             @RequestBody Movie updateMovie) {
        return new ResponseEntity<>(movieService.updateMovie(id, updateMovie), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return new ResponseEntity<>("Resource deleted successfully!.", HttpStatus.OK);
    }

    @PatchMapping("/{id}/{firstName}")
    public ResponseEntity<Movie> updateMovieTitle(@PathVariable Long id,
                                                  @PathVariable String title) {

        return new ResponseEntity<>(movieService.updateMovieTitle(id, title), HttpStatus.OK);
    }
}
