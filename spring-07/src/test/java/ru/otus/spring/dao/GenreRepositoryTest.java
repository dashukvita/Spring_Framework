package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.otus.spring.entity.Genre;
import ru.otus.spring.repository.GenreRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@DisplayName("GenreRepositoryJpa")
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    @DisplayName("получение жанра по id из бд корректно")
    void getById() {
        int id = 1;
        Genre genre = genreRepository.findById(id);

        assertThat(genre).isNotNull();
        assertThat(genre.getGenreName()).isEqualTo("Детектив");
        assertThat(genre.getCodeGenre()).isEqualTo("ХЛ");
    }

    @Test
    @DisplayName("все жанры из бд получены")
    void findAll() {
        List<Genre> genre = genreRepository.findAll();

        assertThat(genre).isNotNull();
        assertEquals(genre.size(), 2);
    }

    @Test
    @DisplayName("добавление жанра в бд корректно")
    void create() {
        String genreName = "Genre3";
        String codeGenre = "G3";
        Genre genre = new Genre();
        genre.setCodeGenre(codeGenre);
        genre.setGenreName(genreName);

        genreRepository.save(genre);
        List<Genre> genres = genreRepository.findAll();


        assertThat(genres.get(2)).isEqualToIgnoringGivenFields(genre, "id");
    }

    @Test
    @DisplayName("удаление жанра из бд корректно")
    void delete() {
        int id = 2;
        Genre genre = genreRepository.findById(id);
        genreRepository.delete(genre);
        List<Genre> genres  = genreRepository.findAll();

        assertEquals(genres.size(), 1);
    }
}
