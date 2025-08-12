package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.otus.spring.entity.Genre;
import ru.otus.spring.exception.GenreNotFoundException;
import ru.otus.spring.repository.GenreRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@DisplayName("GenreRepository")
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    @DisplayName("fetching genre by id from db is correct")
    void getById() {
        Long id = 1L;
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new GenreNotFoundException("Genre with id " + id + " not found."));

        assertThat(genre).isNotNull();
        assertThat(genre.getGenreName()).isEqualTo("Детектив");
        assertThat(genre.getCodeGenre()).isEqualTo("ХЛ");
    }

    @Test
    @DisplayName("all genres are fetching from db")
    void findAll() {
        List<Genre> genre = genreRepository.findAll();

        assertThat(genre).isNotNull();
        assertThat(genre).hasSize(2);
    }

    @Test
    @DisplayName("adding genre from db is correct")
    void create() {
        int beforeCount = genreRepository.findAll().size();

        String genreName = "Genre3";
        String codeGenre = "G3";
        Genre genre = new Genre();
        genre.setCodeGenre(codeGenre);
        genre.setGenreName(genreName);

        genreRepository.save(genre);
        List<Genre> genres = genreRepository.findAll();

        assertThat(genres).hasSize(beforeCount + 1);
        assertThat(genres).anySatisfy(g -> {
            assertThat(g.getCodeGenre()).isEqualTo(codeGenre);
            assertThat(g.getGenreName()).isEqualTo(genreName);
        });
    }

    @Test
    @DisplayName("deleting genre from db is correct")
    void delete() {
        int beforeCount = genreRepository.findAll().size();

        Long id = 2L;
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new GenreNotFoundException("Genre with id " + id + " not found."));
        genreRepository.delete(genre);
        List<Genre> genres  = genreRepository.findAll();

        assertThat(genres).hasSize(beforeCount - 1);
    }
}
