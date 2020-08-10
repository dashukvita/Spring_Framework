package ru.otus.spring.services.imp;

import ru.otus.spring.domain.Genre;

import java.util.List;

public interface GenreService {

    Genre saveGenre(String codegenre, String genreName);

    Genre removeGenre(long id) throws Exception;

    Genre findByIdGenre(long id) throws Exception;

    List<Genre> findAllGenres();
}
