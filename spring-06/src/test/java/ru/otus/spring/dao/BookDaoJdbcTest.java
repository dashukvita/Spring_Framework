package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.spring.domain.Book;

import java.util.List;

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
        Book book = bookDaoJdbc.getById(id);

        assertThat(book).isNotNull();
        assertThat(book.getBookName()).isEqualTo("Book1");
        assertThat(book.getAuthor().getFirstName()).isEqualTo("Author1");
        assertThat(book.getGenre().getGenre()).isEqualTo("Детектив");
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
        long id = 3;
        String bookName = "Book3";
        Book book = new Book(id, authorDao.getById(1), genreDao.getById(1),bookName);

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
