package ru.otus.spring.repositories.impl;

import ru.otus.spring.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {

    Genre save(Genre genre);

    void remove(Genre genre);

    Optional<Genre> findById(long id);

    List<Genre> findAll();
}
