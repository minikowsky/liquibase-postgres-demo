package pl.liquibase.postgres.demo.api;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "MOVIES")
@Data
public class MovieEntity {
    @Id
    @Column(name = "TITLE")
    private String title;

    @Column(name = "RECORD_DATETIME")
    private LocalDateTime dateTime;


    public MovieEntity title(String title) {
        this.title = title;
        return this;
    }

    public MovieEntity dateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }
}
