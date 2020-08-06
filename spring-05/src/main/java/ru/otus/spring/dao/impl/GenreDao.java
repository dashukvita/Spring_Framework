package ru.otus.spring.dao.impl;

import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreDao {

    Genre create(Genre genre);

    void deleteById(long id);

    Optional<Genre> getById(long id);

    List<Genre> getAll();
}
