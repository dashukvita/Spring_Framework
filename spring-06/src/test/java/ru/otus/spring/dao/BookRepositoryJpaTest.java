package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.otus.spring.domain.Book;
import ru.otus.spring.repositories.AuthorRepositoryJpa;
import ru.otus.spring.repositories.BookRepositoryJpa;
import ru.otus.spring.repositories.GenreRepositoryJpa;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@Import({BookRepositoryJpa.class, AuthorRepositoryJpa.class, GenreRepositoryJpa.class})
@AutoConfigureTestDatabase(replace = NONE)
@DisplayName("Класс BookDaoJdbc")
public class BookRepositoryJpaTest {

//    @Autowired
//    private BookRepositoryJpa bookRepositoryJpa;
//    @Autowired
//    private AuthorRepositoryJpa authorDao;
//    @Autowired
//    private GenreRepositoryJpa genreDao;
//
//    @Test
//    @DisplayName("получение книги по id из бд корректно")
//    void getById() {
//        int id = 1;
//        Optional<Book> book = bookRepositoryJpa.findById(id);
//
//        assertThat(book).isNotNull();
//        assertThat(book.get().getBookName()).isEqualTo("Book1");
//        assertThat(book.get().getAuthor().getFirstName()).isEqualTo("Author1");
//        assertThat(book.get().getGenreName().getGenreName()).isEqualTo("Детектив");
//    }
//
//    @Test
//    @DisplayName("все книги из бд получены")
//    void getAll() {
//        List<Book> book = bookRepositoryJpa.findAll();
//
//        assertThat(book).isNotNull();
//        assertEquals(book.size(), 2);
//    }
//
//    @Test
//    @DisplayName("добавление книги в бд корректно")
//    void create() {
//        long id = 3;
//        String bookName = "Book3";
//        Book book = new Book(id, authorDao.findById(1), genreDao.findById(1),bookName);
//
//        bookRepositoryJpa.save(book);
//        List<Book> books = bookRepositoryJpa.findAll();
//
//        assertEquals(books.get(2).getAuthor().getLastName(), "Author1");
//        assertEquals(books.get(2).getGenreName().getGenreName(), "Детектив");
//    }
//
//    @Test
//    @DisplayName("удаление книги из бд корректно")
//    void delete() {
//        int id = 3;
//        Optional<Book> book = bookRepositoryJpa.findById(id);
//        bookRepositoryJpa.remove(book);
//        List<Book> books = bookRepositoryJpa.findAll();
//
//        assertEquals(books.size(), 2);
//    }
}
