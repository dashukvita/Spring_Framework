package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.otus.spring.entity.Author;
import ru.otus.spring.exception.AuthorNotFoundException;
import ru.otus.spring.repository.AuthorRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@DisplayName("AuthorRepository")
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    @DisplayName("fetching author by id from database is correct")
    void getById() {
        Author author = authorRepository.findById(1L).orElseThrow(() -> new AuthorNotFoundException("Author with id " + 1L + " not found."));

        assertThat(author).isNotNull();
        assertThat(author.getFirstName()).isEqualTo("Author1");
        assertThat(author.getLastName()).isEqualTo("Author1");
        assertThat(author.getBirthday()).isEqualTo("31.07.1965");
    }

    @Test
    @DisplayName("all authors are fetching from db")
    void findAll() {
        List<Author> authors = authorRepository.findAll();

        assertThat(authors).isNotNull();
        assertEquals(2, authors.size());
    }

    @Test
    @DisplayName("adding author is correct")
    void create() {
        String firstName = "Author3";
        String lastName = "Author3";
        String birthDay = "05.01.1932";
        Author author = new Author()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setBirthday(birthDay);
        authorRepository.save(author);
        List<Author> authors = authorRepository.findAll();

        assertThat(authors).anySatisfy(a -> {
            assertThat(a.getFirstName()).isEqualTo(firstName);
            assertThat(a.getLastName()).isEqualTo(lastName);
            assertThat(a.getBirthday()).isEqualTo(birthDay);
        });
        assertEquals(3, authors.size());
    }

    @Test
    @DisplayName("deleting author from db is correct")
    void delete() {
        Author author= authorRepository.findById(2L).orElseThrow(() -> new AuthorNotFoundException("Author with id " + 2L + " not found."));;
        authorRepository.delete(author);
        List<Author> authors = authorRepository.findAll();

        assertEquals(1, authors.size());
        assertFalse(authorRepository.findById(2L).isPresent());
    }
}
