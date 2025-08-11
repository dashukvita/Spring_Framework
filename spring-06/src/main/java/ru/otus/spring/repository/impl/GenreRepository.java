package ru.otus.spring.repository.impl;

import ru.otus.spring.entity.Genre;

import java.util.List;

public interface GenreRepository {

    Genre save(Genre genre);

    void remove(Genre genre);

    Genre findById(long id);

    List<Genre> findAll();
}
