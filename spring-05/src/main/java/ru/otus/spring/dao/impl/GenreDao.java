package ru.otus.spring.dao.impl;

import ru.otus.spring.domain.Genre;

import java.util.List;

public interface GenreDao {

    void create(Genre genre);

    void deleteById(long id);

    Genre getById(long id);

    List<Genre> getAll();
}
