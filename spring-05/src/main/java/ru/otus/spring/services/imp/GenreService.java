package ru.otus.spring.services.imp;

import ru.otus.spring.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {

    Genre createGenre(String codegenre, String genreName);

    Optional<Genre> deleteGenre(long id);

    Optional<Genre> getByIdGenre(long id);

    List<Genre> getAllGenres();
}
