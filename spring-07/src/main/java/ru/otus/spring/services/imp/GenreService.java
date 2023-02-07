package ru.otus.spring.services.imp;

import ru.otus.spring.domain.Genre;

import java.util.List;

public interface GenreService {

    Genre save(String code, String genreName);

    Genre remove(long id);

    Genre findById(long id);

    Genre findByTitle(String title) throws Exception;

    List<Genre> findAllGenres();
}
