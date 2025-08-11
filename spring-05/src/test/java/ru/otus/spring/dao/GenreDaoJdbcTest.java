package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.spring.entity.Genre;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@JdbcTest
@Import(GenreDaoJdbc.class)
@AutoConfigureTestDatabase(replace = NONE)
@DisplayName("Класс GenreDaoJdbcTest")
public class GenreDaoJdbcTest {

    @Autowired
    private GenreDaoJdbc genreDaoJdbc;

    @Test
    @DisplayName("получение жанра по id из бд корректно")
    void getById() {
        int id = 1;
        Optional<Genre> genre = genreDaoJdbc.getById(id);

        assertThat(genre).isNotNull();
        assertThat(genre.get().getGenre()).isEqualTo("Детектив");
        assertThat(genre.get().getCodeGenre()).isEqualTo("ХЛ");
    }

    @Test
    @DisplayName("все жанры из бд получены")
    void getAll() {
        List<Genre> genre = genreDaoJdbc.getAll();

        assertThat(genre).isNotNull();
        assertEquals(genre.size(), 2);
    }

    @Test
    @DisplayName("добавление жанра в бд корректно")
    void create() {
        long genreId = 3;
        String genreName = "Genre3";
        String codeGenre = "G3";
        Genre genre = new Genre(genreId, codeGenre, genreName);
        genreDaoJdbc.create(genre);
        List<Genre> genres = genreDaoJdbc.getAll();


        assertThat(genres.get(2)).isEqualToIgnoringGivenFields(genre, "id");
    }

    @Test
    @DisplayName("удаление жанра из бд корректно")
    void delete() {
        genreDaoJdbc.deleteById(3);
        List<Genre> genres  = genreDaoJdbc.getAll();

        assertEquals(genres.size(), 2);
    }
}
