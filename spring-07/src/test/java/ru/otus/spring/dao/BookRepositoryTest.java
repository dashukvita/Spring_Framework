package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.otus.spring.entity.Book;
import ru.otus.spring.exception.AuthorNotFoundException;
import ru.otus.spring.exception.BookNotFoundException;
import ru.otus.spring.exception.GenreNotFoundException;
import ru.otus.spring.repository.AuthorRepository;
import ru.otus.spring.repository.BookRepository;
import ru.otus.spring.repository.GenreRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@DisplayName("BookRepository")
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GenreRepository genreRepository;

    @Test
    @DisplayName("fetching book by id from db is correct")
    void getById() {
        Book book = bookRepository.findById(1L).orElseThrow(() -> new BookNotFoundException("Book with id " + 1L + " not found."));

        assertThat(book).isNotNull();
        assertThat(book.getBookName()).isEqualTo("Book1");
        assertThat(book.getAuthor().getFirstName()).isEqualTo("Author1");
        assertThat(book.getGenre().getGenreName()).isEqualTo("Detective");
    }

    @Test
    @DisplayName("all books are fetching from db")
    void getAll() {
        List<Book> book = bookRepository.findAll();

        assertThat(book).isNotNull();
        assertEquals(2, book.size());
    }

    @Test
    @DisplayName("adding book from db is correct")
    void create() {
        Long id = 1L;
        String bookName = "Book3";
        Book book = new Book()
                .setGenre(genreRepository.findById(id).orElseThrow(() -> new GenreNotFoundException("Genre with id " + id + " not found.")))
                .setAuthor(authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("Author with id " + id + " not found.")))
                .setBookName(bookName);

        bookRepository.save(book);
        List<Book> books = bookRepository.findAll();

        assertThat(books).hasSize(3);
        Book lastBook = books.get(books.size() - 1);
        assertThat(lastBook.getAuthor().getLastName()).isEqualTo("Author1");
        assertThat(lastBook.getGenre().getGenreName()).isEqualTo("Detective");
    }

    @Test
    @DisplayName("удаление книги из бд корректно")
    void delete() {
        Book book = bookRepository.findById(2L).orElseThrow(() -> new BookNotFoundException("Book with id " + 2L + " not found."));
        bookRepository.delete(book);
        List<Book> books = bookRepository.findAll();

        assertEquals(1, books.size());
    }
}
