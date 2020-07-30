package ru.otus.spring.repositories.impl;

import ru.otus.spring.domain.Genre;

import java.util.List;

public interface GenreRepository {

    Genre save(Genre genre);

    void remove(Genre genre);

    Genre findById(long id);

    List<Genre> findAll();
}
