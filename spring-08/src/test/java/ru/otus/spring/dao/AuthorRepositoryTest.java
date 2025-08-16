package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.spring.entity.Author;
import ru.otus.spring.exception.AuthorNotFoundException;
import ru.otus.spring.repository.AuthorRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@DisplayName("AuthorRepository")
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    @DisplayName("fetching author by id from database is correct")
    void getById() {
        Author savedAuthor = authorRepository.save(Author.builder()
                .name("Author3")
                .surname("Author3")
                .birthday("1965-07-31")
                .build());

        Author author = authorRepository.findById(savedAuthor.getId())
                .orElseThrow(() -> new AuthorNotFoundException("Author with id " + savedAuthor.getId() + " not found."));

        assertThat(author).isNotNull();
        assertThat(author.getName()).isEqualTo("Author3");
        assertThat(author.getSurname()).isEqualTo("Author3");
        assertThat(author.getBirthday()).isEqualTo("1965-07-31");
    }

    @Test
    @DisplayName("all authors are fetching from db")
    void findAll() {
        List<Author> authors = authorRepository.findAll();

        assertThat(authors).isNotNull();
        assertEquals(3, authors.size());
    }

    @Test
    @DisplayName("adding author is correct")
    void create() {
        String firstName = "Author4";
        String lastName = "Author4";
        String birthDay = "05.01.1932";

        Author author = Author.builder()
                .name(firstName)
                .surname(lastName)
                .birthday(birthDay)
                .build();

        authorRepository.save(author);
        List<Author> authors = authorRepository.findAll();

        assertThat(authors).anySatisfy(a -> {
            assertThat(a.getName()).isEqualTo(firstName);
            assertThat(a.getSurname()).isEqualTo(lastName);
            assertThat(a.getBirthday()).isEqualTo(birthDay);
        });
        assertEquals(4, authors.size());
    }

    @Test
    @DisplayName("deleting author from db is correct")
    void delete() {
        Author savedAuthor = authorRepository.save(Author.builder()
                .name("Author5")
                .surname("Author5")
                .birthday("1990-07-31")
                .build());

        Author author= authorRepository.findById(savedAuthor.getId()).orElseThrow(() -> new AuthorNotFoundException("Author with id " + 2L + " not found."));;

        authorRepository.delete(author);
        List<Author> authors = authorRepository.findAll();

        assertEquals(1, authors.size());
        assertFalse(authorRepository.findById(savedAuthor.getId()).isPresent());
    }
}
