package com.example.restfullapi.contoller;

import com.example.restfullapi.model.Movie;
import com.example.restfullapi.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return new ResponseEntity<>(movieService.getMovieById(id), HttpStatus.OK);
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
