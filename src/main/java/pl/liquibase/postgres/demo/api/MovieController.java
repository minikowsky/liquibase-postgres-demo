package pl.liquibase.postgres.demo.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieService service;

    @GetMapping("/{title}")
    public ResponseEntity<?> getByTitle(@PathVariable("title") final String title) {
        MovieEntity entity = service.getOne(title);
        return ResponseEntity.ok(Objects.requireNonNullElse(entity, HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody String title) {
        return ResponseEntity.ok(service.create(title));
    }
}
