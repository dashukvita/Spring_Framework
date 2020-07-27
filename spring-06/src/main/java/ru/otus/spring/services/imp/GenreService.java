package ru.otus.spring.services.imp;

import ru.otus.spring.domain.Genre;

import java.util.List;

public interface GenreService {

    Genre createGenre(long genre_id, String codegenre, String genreName);

    Genre deleteGenre(long id);

    Genre getByIdGenre(long id);

    List<Genre> getAllGenres();
}
