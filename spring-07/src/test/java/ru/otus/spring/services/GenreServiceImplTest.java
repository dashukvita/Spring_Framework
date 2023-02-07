package ru.otus.spring.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.repositories.GenreRepository;
import ru.otus.spring.services.imp.GenreService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@DisplayName("Класс GenreService")
public class GenreServiceImplTest {

    private GenreRepository genreRepository;
    private GenreService genreService;

    @BeforeEach
    void setUp() {
        genreRepository = mock(GenreRepository.class);
        genreService = new GenreServiceImpl(genreRepository);
    }

    @Test
    @DisplayName("получение жанра из бд корректно")
    void getAllAuthors() {
        ArrayList<Genre> genres = new ArrayList<>();
        when(genreRepository.findAll()).thenReturn(genres);

        List<Genre> resultAuthors = genreService.findAllGenres();

        assertThat(resultAuthors).isNotNull();
        assertThat(resultAuthors).isEqualTo(genres);
        verify(genreRepository).findAll();
        verifyNoMoreInteractions(genreRepository);
    }

    @Test
    @DisplayName("создание жанра корректно")
    void createAuthor() {
        String codeGenre = "G3";
        String genreTitle = "Genre3";

        Genre genre = new Genre()
                .setCode(codeGenre)
                .setTitle(genreTitle);

        when(genreRepository.save(any(Genre.class))).thenReturn(genre);

        Genre resultGenre = genreService.save(codeGenre, genreTitle);

        assertThat(resultGenre).isNotNull();
        assertThat(resultGenre.getCode()).isEqualTo(codeGenre);
        assertThat(resultGenre.getTitle()).isEqualTo(genreTitle);
        verify(genreRepository).save(any(Genre.class));
        verifyNoMoreInteractions(genreRepository);
    }
}
