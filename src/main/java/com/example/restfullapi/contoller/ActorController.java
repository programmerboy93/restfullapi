package com.example.restfullapi.contoller;

import com.example.restfullapi.model.Actor;
import com.example.restfullapi.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/actors")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @GetMapping
    public ResponseEntity<List<Actor>> getAllActors() {
        return ResponseEntity.ok(actorService.getAllActors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActor(@PathVariable Long id) {
        return new ResponseEntity<>(actorService.getActorById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Actor> addActor(@RequestBody Actor newActor) {
        return new ResponseEntity<>(actorService.saveActor(newActor), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Actor> updateActor(@PathVariable Long id,
                                             @RequestBody Actor editActor) {
        return new ResponseEntity<>(actorService.updateActor(id,editActor),HttpStatus.OK);
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
