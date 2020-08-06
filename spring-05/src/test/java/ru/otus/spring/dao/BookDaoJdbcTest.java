package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@JdbcTest
@Import({BookDaoJdbc.class, AuthorDaoJdbc.class, GenreDaoJdbc.class})
@AutoConfigureTestDatabase(replace = NONE)
@DisplayName("Класс BookDaoJdbc")
public class BookDaoJdbcTest {

    @Autowired
    private BookDaoJdbc bookDaoJdbc;
    @Autowired
    private AuthorDaoJdbc authorDao;
    @Autowired
    private GenreDaoJdbc genreDao;

    @Test
    @DisplayName("получение книги по id из бд корректно")
    void getById() {
        int id = 1;
        Optional<Book> book = bookDaoJdbc.getById(id);

        assertThat(book).isNotNull();
        assertThat(book.get().getBookName()).isEqualTo("Book1");
        assertThat(book.get().getAuthor().getFirstName()).isEqualTo("Author1");
        assertThat(book.get().getGenre().getGenre()).isEqualTo("Детектив");
    }

    @Test
    @DisplayName("все книги из бд получены")
    void getAll() {
        List<Book> book = bookDaoJdbc.getAll();

        assertThat(book).isNotNull();
        assertEquals(book.size(), 2);
    }

    @Test
    @DisplayName("добавление книги в бд корректно")
    void create() {
        String bookName = "Book3";

        Author author = authorDao.getById(1).get();
        Genre genre = genreDao.getById(1).get();

        Book book = Book.builder().author(author).genre(genre).bookName(bookName).build();

        bookDaoJdbc.create(book);
        List<Book> books = bookDaoJdbc.getAll();

        assertEquals(books.get(2).getAuthor().getLastName(), "Author1");
        assertEquals(books.get(2).getGenre().getGenre(), "Детектив");
    }

    @Test
    @DisplayName("удаление книги из бд корректно")
    void delete() {
        bookDaoJdbc.deleteById(3);
        List<Book> books = bookDaoJdbc.getAll();

        assertEquals(books.size(), 2);
    }
}
