package ru.otus.spring.services.imp;

import ru.otus.spring.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {

    Genre saveGenre(long genre_id, String codegenre, String genreName);

    Genre removeGenre(long id);

    Genre findByIdGenre(long id);

    List<Genre> findAllGenres();
}
