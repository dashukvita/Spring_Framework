package ru.otus.spring.service;

import ru.otus.spring.entity.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Genre createGenre(String codeGenre, String genreName);
    Genre deleteGenre(Long id);
    Optional<Genre> findById(Long id);
    List<Genre> findAll();
}
