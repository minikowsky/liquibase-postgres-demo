package pl.liquibase.postgres.demo.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;

    public MovieEntity create(final String title) {
        MovieEntity entity = new MovieEntity()
                .title(title)
                .dateTime(LocalDateTime.now());

        return repository.save(entity);
    }

    public List<MovieEntity> findAll() {
        return repository.findAll();
    }

    public MovieEntity getOne(final String title) {
        return repository.getReferenceById(title);
    }
}
