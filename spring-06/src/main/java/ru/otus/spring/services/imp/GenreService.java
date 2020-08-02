package ru.otus.spring.services.imp;

import ru.otus.spring.domain.Genre;

import java.util.List;

public interface GenreService {

    Genre saveGenre(String codegenre, String genreName);

    Genre removeGenre(long id);

    Genre findByIdGenre(long id);

    List<Genre> findAllGenres();
}
