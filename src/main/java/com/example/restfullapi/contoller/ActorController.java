package com.example.restfullapi.contoller;

import com.example.restfullapi.model.dto.ActorDto;
import com.example.restfullapi.model.dto.ActorWithoutMoviesDto;
import com.example.restfullapi.model.dto.MovieWithoutActorDto;
import com.example.restfullapi.model.entity.Actor;
import com.example.restfullapi.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/actors")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @GetMapping
    public ResponseEntity<CollectionModel<ActorWithoutMoviesDto>> getAllActors() {
        List<ActorWithoutMoviesDto> actors = actorService.getAllActors().stream()
                .map(a -> a.add(linkTo(methodOn(ActorController.class).getActor(a.getId())).withRel("actorMovies")))
                .collect(Collectors.toList());

        Link link = linkTo(methodOn(ActorController.class).getAllActors()).withSelfRel();
        return ResponseEntity.ok(new CollectionModel<>(actors, link));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorDto> getActor(@PathVariable Long id) {
        ActorDto actor = actorService.getActorById(id);
        actor.add(linkTo(methodOn(ActorController.class).getActor(actor.getId())).withSelfRel());
        actor.add(linkTo(methodOn(ActorController.class).getAllActors()).withRel("actors"));
        for (MovieWithoutActorDto movie : actor.getMovies()) {
            movie.add(linkTo(methodOn(MovieController.class).getMovie(movie.getId())).withRel("movie"));
        }

        return new ResponseEntity<>(actor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Actor> addActor(@RequestBody Actor newActor) {
        return new ResponseEntity<>(actorService.saveActor(newActor), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Actor> updateActor(@PathVariable Long id,
                                             @RequestBody Actor editActor) {
        return new ResponseEntity<>(actorService.updateActor(id, editActor), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteActor(@PathVariable Long id) {
        actorService.delete(id);
        return new ResponseEntity<>("Resource deleted successfully!.", HttpStatus.OK);
    }

    @PatchMapping("/{id}/{firstName}")
    public ResponseEntity<Actor> updateActor(@Valid @PathVariable String firstName,
                                             @PathVariable Long id) {

        return new ResponseEntity<>(actorService.update(id, firstName), HttpStatus.OK);
    }
}
