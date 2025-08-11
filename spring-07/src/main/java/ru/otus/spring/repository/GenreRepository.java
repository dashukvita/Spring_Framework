package ru.otus.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
