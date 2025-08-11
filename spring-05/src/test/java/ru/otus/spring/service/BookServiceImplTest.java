package ru.otus.spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.dao.impl.AuthorDao;
import ru.otus.spring.dao.impl.BookDao;
import ru.otus.spring.dao.impl.GenreDao;
import ru.otus.spring.entity.Author;
import ru.otus.spring.entity.Book;
import ru.otus.spring.entity.Genre;
import ru.otus.spring.service.imp.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        bookService = new BookServiceImpl(authorDao, bookDao, genreDao );
    }

    @Test
    @DisplayName("получение книги по id из бд корректно")
    void getBook() {
        int id = 1;
        Author author = new Author(id, "firstName", "lastName", "birthday");
        Genre genre = new Genre(id, "code", "genre");
        Book book = new Book(id, author, genre,"testBook");

        when(bookDao.getById(id)).thenReturn(Optional.ofNullable(book));

        Book resultBook = bookService.getByIdBook(id).get();

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
    @DisplayName("создание книги корректно")
    void createBook() {
        String firstName = "Author3";
        String lastName = "Author3";
        String birthDay = "05.01.1932";

        String genreName = "Genre3";
        String codeGenre = "G3";

        String bookName = "BookTest";

        Author author = Author.builder().firstName(firstName).lastName(lastName).birthday(birthDay).build();
        authorDao.create(author);

        Genre genre  = Genre.builder().codeGenre(codeGenre).genre(genreName).build();
        genreDao.create(genre);

        when(authorDao.getById(author.getId())).thenReturn(Optional.of(author));
        when(genreDao.getById(genre.getId())).thenReturn(Optional.of(genre));

        Book resultBook = bookService.createBook(author.getId(), genre.getId(), bookName);

        assertThat(resultBook).isNotNull();
        assertThat(resultBook.getBookName()).isEqualTo(bookName);
        assertThat(resultBook.getAuthor().getId()).isEqualTo(author.getId());
        assertThat(resultBook.getGenre()).isEqualTo(genre);

        verify(bookDao).create(any(Book.class));
        verify(authorDao).getById(author.getId());
        verify(genreDao).getById(genre.getId());
        verifyNoMoreInteractions(bookDao);
    }

    @Test
    @DisplayName("удаление книги из бд корректно")
    void deleteBook() {
        int id = 1;
        Author author = new Author(id, "firstName", "lastName", "birthday");
        Genre genre = new Genre(id, "code", "genre");
        Book book = new Book(id, author, genre,"testBook");

        when(bookDao.getById(id)).thenReturn(Optional.of(book));

        Book resultBook = bookService.deleteBook(id).get();

        assertThat(resultBook).isNotNull();
        assertThat(resultBook.getId()).isEqualTo(id);

        verify(bookDao).getById(id);
        verify(bookDao).deleteById(id);
        verifyNoMoreInteractions(bookDao);
    }
}
