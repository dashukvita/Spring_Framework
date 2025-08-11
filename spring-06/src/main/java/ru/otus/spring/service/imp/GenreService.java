package ru.otus.spring.service.imp;

import ru.otus.spring.entity.Genre;

import java.util.List;

public interface GenreService {

    Genre saveGenre(String codegenre, String genreName);

    Genre removeGenre(long id) throws Exception;

    Genre findByIdGenre(long id) throws Exception;

    List<Genre> findAllGenres();
}
