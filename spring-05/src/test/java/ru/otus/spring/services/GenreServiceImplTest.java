package ru.otus.spring.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.dao.impl.GenreDao;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.services.imp.GenreService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@DisplayName("Класс GenreService")
public class GenreServiceImplTest {

    private GenreDao genreDao;
    private GenreService genreService;

    @BeforeEach
    void setUp() {
        genreDao = mock(GenreDao.class);
        genreService = new GenreServiceImpl(genreDao);
    }

    @Test
    @DisplayName("получение жанра из бд корректно")
    void getAllAuthors() {
        ArrayList<Genre> genres = new ArrayList<>();
        when(genreDao.getAll()).thenReturn(genres);

        List<Genre> resultAuthors = genreService.getAllGenres();

        assertThat(resultAuthors).isNotNull();
        assertThat(resultAuthors).isEqualTo(genres);
        verify(genreDao).getAll();
        verifyNoMoreInteractions(genreDao);
    }

    @Test
    @DisplayName("создание жанра корректно")
    void createAuthor() {
        String codeGenre = "G3";
        String genreName = "Genre3";

        Genre resultGenre = genreService.createGenre(codeGenre, genreName);

        assertThat(resultGenre).isNotNull();
        assertThat(resultGenre.getCodeGenre()).isEqualTo(codeGenre);
        assertThat(resultGenre.getGenre()).isEqualTo(genreName);
        verify(genreDao).create(any(Genre.class));
        verifyNoMoreInteractions(genreDao);
    }
}
