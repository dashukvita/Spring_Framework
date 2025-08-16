package ru.otus.spring.service;

import ru.otus.spring.entity.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Genre createGenre(String codeGenre, String genreName);
    Genre deleteGenre(String id);
    Optional<Genre> findById(String id);
    List<Genre> findAll();
}
