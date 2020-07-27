package ru.otus.spring.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.dao.impl.AuthorDao;
import ru.otus.spring.dao.impl.BookDao;
import ru.otus.spring.dao.impl.GenreDao;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.services.imp.BookService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@DisplayName("Класс BookService")
public class BookServiceImplTest {

    private AuthorDao authorDao;
    private BookDao bookDao;
    private GenreDao genreDao;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        authorDao = mock(AuthorDao.class);
        bookDao = mock(BookDao.class);
        genreDao = mock(GenreDao.class);

        bookService = new BookServiceImpl(authorDao, bookDao, genreDao);
    }

    @Test
    @DisplayName("получение книги по id из бд корректно")
    void getBook() {
        long id = 3;
        String bookName = "Book3";
        Book book = new Book(id, authorDao.getById(1), genreDao.getById(1),bookName);
        when(bookDao.getById(id)).thenReturn(book);

        Book resultBook = bookService.getByIdBook(id);

        assertThat(resultBook).isNotNull();
        assertThat(resultBook).isEqualTo(book);
        verify(bookDao).getById(id);
        verifyNoMoreInteractions(bookDao);
    }

    @Test
    @DisplayName("получение всех книг из бд корректно")
    void getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        when(bookDao.getAll()).thenReturn(books);

        List<Book> allBooks = bookService.getAllBooks();

        assertThat(allBooks).isNotNull();
        assertThat(allBooks).isEqualTo(books);
        verify(bookDao).getAll();
        verifyNoMoreInteractions(bookDao);
    }

    @Test
    @DisplayName("удаление книги из бд корректно")
    void deleteBook() {
        int id = 1;
        Book book = new Book(id, authorDao.getById(1), genreDao.getById(1), "bookName");

        when(bookDao.getById(id)).thenReturn(book);

        Book resultBook = bookService.deleteBook(id);

        assertThat(resultBook).isNotNull();
        assertThat(resultBook.getId()).isEqualTo(id);

        verify(bookDao).getById(id);
        verify(bookDao).deleteById(id);
    }

    @Test
    @DisplayName("создание книги корректно")
    void createBook() {
        long authorId = 3;
        String firstName = "Author3";
        String lastName = "Author3";
        String birthDay = "05.01.1932";

        long genreId = 3;
        String genreName = "Genre3";
        String codeGenre = "G3";

        String bookName = "BookTest";

        Genre genre = new Genre(genreId, codeGenre, genreName);
        Author author = new Author(authorId, firstName, lastName, birthDay);

        when(authorDao.getById(author.getId())).thenReturn(author);
        when(genreDao.getById(genre.getId())).thenReturn(genre);

        Book resultBook = bookService.createBook(1, author.getId(), genre.getId(), bookName);

        assertThat(resultBook).isNotNull();
        assertThat(resultBook.getBookName()).isEqualTo(bookName);
        assertThat(resultBook.getAuthor().getId()).isEqualTo(author.getId());
        assertThat(resultBook.getGenre()).isEqualTo(genre);
        verify(bookDao).create(any(Book.class));
        verify(authorDao).getById(author.getId());
        verify(genreDao).getById(genre.getId());
        verifyNoMoreInteractions(bookDao);
        verifyNoMoreInteractions(authorDao);
        verifyNoMoreInteractions(genreDao);
    }
}
