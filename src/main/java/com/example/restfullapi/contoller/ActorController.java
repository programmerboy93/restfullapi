package com.example.restfullapi.contoller;

import com.example.restfullapi.exception.ActorNotCreatedException;
import com.example.restfullapi.exception.ActorNotFoundException;
import com.example.restfullapi.model.Actor;
import com.example.restfullapi.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/actors")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @GetMapping
    public ResponseEntity<List<Actor>> getAllActors() {
        return ResponseEntity.ok(actorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActor(@PathVariable Long id) {
        return actorService.get(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ActorNotFoundException(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Actor> addActor(@RequestBody Actor newActor) {
        return actorService.save(newActor)
                .map(a -> new ResponseEntity<>(a, HttpStatus.CREATED))
                .orElseThrow(ActorNotCreatedException::new);
    }


}
