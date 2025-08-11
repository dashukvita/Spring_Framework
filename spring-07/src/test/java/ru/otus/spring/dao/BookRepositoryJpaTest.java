package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.otus.spring.entity.Book;
import ru.otus.spring.repository.AuthorRepositoryJpa;
import ru.otus.spring.repository.BookRepositoryJpa;
import ru.otus.spring.repository.GenreRepositoryJpa;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@Import({BookRepositoryJpa.class, AuthorRepositoryJpa.class, GenreRepositoryJpa.class})
@AutoConfigureTestDatabase(replace = NONE)
@DisplayName("Класс BookRepositoryJpa")
public class BookRepositoryJpaTest {

    @Autowired
    private BookRepositoryJpa bookRepositoryJpa;
    @Autowired
    private AuthorRepositoryJpa authorRepositoryJpa;
    @Autowired
    private GenreRepositoryJpa genreRepositoryJpa;

    @Test
    @DisplayName("получение книги по id из бд корректно")
    void getById() {
        int id = 1;
        Book book = bookRepositoryJpa.findById(id);

        assertThat(book).isNotNull();
        assertThat(book.getBookName()).isEqualTo("Book1");
        assertThat(book.getAuthor().getFirstName()).isEqualTo("Author1");
        assertThat(book.getGenre().getGenreName()).isEqualTo("Детектив");
    }

    @Test
    @DisplayName("все книги из бд получены")
    void getAll() {
        List<Book> book = bookRepositoryJpa.findAll();

        assertThat(book).isNotNull();
        assertEquals(book.size(), 2);
    }

    @Test
    @DisplayName("добавление книги в бд корректно")
    void create() {
        String bookName = "Book3";
        Book book = new Book()
                .setGenre(genreRepositoryJpa.findById(1))
                .setAuthor(authorRepositoryJpa.findById(1))
                .setBookName(bookName);

        bookRepositoryJpa.save(book);
        List<Book> books = bookRepositoryJpa.findAll();

        assertEquals(books.get(2).getAuthor().getLastName(), "Author1");
        assertEquals(books.get(2).getGenre().getGenreName(), "Детектив");
    }

    @Test
    @DisplayName("удаление книги из бд корректно")
    void delete() {
        int id = 2;
        Book book = bookRepositoryJpa.findById(id);
        bookRepositoryJpa.remove(book);
        List<Book> books = bookRepositoryJpa.findAll();

        assertEquals(books.size(), 1);
    }
}
