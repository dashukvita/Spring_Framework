package ru.otus.spring.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.repositories.impl.GenreRepository;
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

//    private GenreRepository genreRepository;
//    private GenreService genreService;
//
//    @BeforeEach
//    void setUp() {
//        genreRepository = mock(GenreRepository.class);
//        genreService = new GenreServiceImpl(genreRepository);
//    }
//
//    @Test
//    @DisplayName("получение жанра из бд корректно")
//    void getAllAuthors() {
//        ArrayList<Genre> genres = new ArrayList<>();
//        when(genreRepository.findAll()).thenReturn(genres);
//
//        List<Genre> resultAuthors = genreService.findAllGenres();
//
//        assertThat(resultAuthors).isNotNull();
//        assertThat(resultAuthors).isEqualTo(genres);
//        verify(genreRepository).findAll();
//        verifyNoMoreInteractions(genreRepository);
//    }
//
//    @Test
//    @DisplayName("создание жанра корректно")
//    void createAuthor() {
//        long genreId = 3;
//        String codeGenre = "G3";
//        String genreName = "Genre3";
//
//        Genre resultGenre = genreService.saveGenre(genreId, codeGenre, genreName);
//
//        assertThat(resultGenre).isNotNull();
//        assertThat(resultGenre.getCodeGenre()).isEqualTo(codeGenre);
//        assertThat(resultGenre.getGenreName()).isEqualTo(genreName);
//        verify(genreRepository).save(any(Genre.class));
//        verifyNoMoreInteractions(genreRepository);
//    }
}
