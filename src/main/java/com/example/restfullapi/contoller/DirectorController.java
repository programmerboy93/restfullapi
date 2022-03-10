package com.example.restfullapi.contoller;

import com.example.restfullapi.model.dto.DirectorDto;
import com.example.restfullapi.model.dto.DirectorWithoutMovieDto;
import com.example.restfullapi.model.dto.MovieWithoutActorDto;
import com.example.restfullapi.model.entity.Director;
import com.example.restfullapi.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/directors")
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping
    public ResponseEntity<CollectionModel<DirectorWithoutMovieDto>> getAllDirectors() {
        List<DirectorWithoutMovieDto> directors = directorService.getAllDirectors().stream()
                .map(d -> d.add(linkTo(methodOn(DirectorController.class).getDirector(d.getId())).withRel("director")))
                .collect(Collectors.toList());

        Link link = linkTo(methodOn(DirectorController.class).getAllDirectors()).withSelfRel();
        return ResponseEntity.ok(new CollectionModel<>(directors, link));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectorDto> getDirector(@PathVariable Long id) {
        DirectorDto director = directorService.getDirectorById(id);
        director.add(linkTo(methodOn(DirectorController.class).getDirector(director.getId())).withSelfRel());
        director.add(linkTo(methodOn(DirectorController.class).getAllDirectors()).withRel("directors"));
        for (MovieWithoutActorDto movie : director.getMovies()) {
            movie.add(linkTo(methodOn(MovieController.class).getMovie(movie.getId())).withRel("movie"));
        }

        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Director> saveDirector(@RequestBody Director newDirector) {
        return new ResponseEntity<>(directorService.saveDirector(newDirector), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Director> updateDirector(@PathVariable("id") Long id,
                                                   @RequestBody Director updateDirector) {
        return new ResponseEntity<>(directorService.updateDirector(id, updateDirector), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDirector(@PathVariable Long id) {
        directorService.deleteDirector(id);
        return new ResponseEntity<>("Resource deleted successfully!.", HttpStatus.OK);
    }

    @PatchMapping("/{id}/{firstName}")
    public ResponseEntity<Director> updateDirectorFirstName(@PathVariable Long id,
                                                            @PathVariable String firstName) {

        return new ResponseEntity<>(directorService.updateDirectorFirstName(id, firstName), HttpStatus.OK);
    }
}
