package com.example.restfullapi.contoller;

import com.example.restfullapi.model.Director;
import com.example.restfullapi.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directors")
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping
    public ResponseEntity<List<Director>> getAllDirectors() {
        return ResponseEntity.ok(directorService.getAllDirectors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirector(@PathVariable Long id) {
        return new ResponseEntity<>(directorService.getDirectorById(id), HttpStatus.OK);
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
