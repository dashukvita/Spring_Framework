package ru.otus.spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.entity.Genre;
import ru.otus.spring.repository.GenreRepository;
import ru.otus.spring.service.imp.GenreServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DisplayName("GenreService")
public class GenreServiceImplTest {

    private GenreRepository genreRepository;
    private GenreService genreService;

//    @BeforeEach
//    void setUp() {
//        genreRepository = mock(GenreRepository.class);
//        genreService = new GenreServiceImpl(genreRepository);
//    }
//
//    @Test
//    @DisplayName("fetching genre from db is correct")
//    void getAllGenres() {
//        ArrayList<Genre> genres = new ArrayList<>();
//        when(genreRepository.findAll()).thenReturn(genres);
//
//        List<Genre> resultAuthors = genreService.findAll();
//
//        assertThat(resultAuthors).isNotNull();
//        assertThat(resultAuthors).isEqualTo(genres);
//        verify(genreRepository).findAll();
//        verifyNoMoreInteractions(genreRepository);
//    }
//
//    @Test
//    @DisplayName("creating genre is correct")
//    void createGenre() {
//        String codeGenre = "G3";
//        String genreName = "Genre3";
//
//        when(genreRepository.save(any(Genre.class))).thenAnswer(invocation -> invocation.getArgument(0));
//        Genre resultGenre = genreService.createGenre(codeGenre, genreName);
//
//        assertThat(resultGenre).isNotNull();
//        assertThat(resultGenre.getCodeGenre()).isEqualTo(codeGenre);
//        assertThat(resultGenre.getGenreName()).isEqualTo(genreName);
//
//        verify(genreRepository).save(any(Genre.class));
//        verifyNoMoreInteractions(genreRepository);
//    }
}
