package ru.otus.spring.service;

import ru.otus.spring.entity.Genre;

import java.util.List;

public interface GenreService {
    Genre createGenre(String codeGenre, String genreName);
    Genre deleteGenre(Long id) throws Exception;
    Genre findById(Long id) throws Exception;
    List<Genre> findAll();
}
