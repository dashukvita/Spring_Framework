package ru.otus.spring.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {
    private static final long AUTHOR_ID = 1;
    private static final long GENRE_ID = 1;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void findAllByAuthor() {
        Author author = new Author().setId(AUTHOR_ID);

        List<Book> books = bookRepository.findAllByAuthor(author);
        Book resBook = entityManager.find(Book.class, books.get(0).getId());

        assertThat(resBook).isEqualTo(books.get(0));
    }

    @Test
    void findAllByGenre() {
        Genre genre = new Genre().setId(GENRE_ID);

        List<Book> books = bookRepository.findAllByGenre(genre);
        Book resBook = entityManager.find(Book.class, books.get(0).getId());

        assertThat(resBook).isEqualTo(books.get(0));
    }
}
