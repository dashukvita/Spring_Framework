package ru.otus.spring.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.repositories.impl.AuthorRepository;
import ru.otus.spring.repositories.impl.BookRepository;
import ru.otus.spring.repositories.impl.GenreRepository;
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

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private GenreRepository genreRepository;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        authorRepository = mock(AuthorRepository.class);
        bookRepository = mock(BookRepository.class);
        genreRepository = mock(GenreRepository.class);

        bookService = new BookServiceImpl(authorRepository, bookRepository, genreRepository);
    }

    @Test
    @DisplayName("получение книги по id из бд корректно")
    void getBook() {
        long id = 3;
        String bookName = "Book3";
        Book book = new Book(id, authorRepository.getById(1), genreRepository.getById(1),bookName);
        when(bookRepository.getById(id)).thenReturn(book);

        Book resultBook = bookService.getByIdBook(id);

        assertThat(resultBook).isNotNull();
        assertThat(resultBook).isEqualTo(book);
        verify(bookRepository).getById(id);
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    @DisplayName("получение всех книг из бд корректно")
    void getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        when(bookRepository.getAll()).thenReturn(books);

        List<Book> allBooks = bookService.getAllBooks();

        assertThat(allBooks).isNotNull();
        assertThat(allBooks).isEqualTo(books);
        verify(bookRepository).getAll();
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    @DisplayName("удаление книги из бд корректно")
    void deleteBook() {
        int id = 1;
        Book book = new Book(id, authorRepository.getById(1), genreRepository.getById(1), "bookName");

        when(bookRepository.getById(id)).thenReturn(book);

        Book resultBook = bookService.deleteBook(id);

        assertThat(resultBook).isNotNull();
        assertThat(resultBook.getId()).isEqualTo(id);

        verify(bookRepository).getById(id);
        verify(bookRepository).deleteById(id);
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

        when(authorRepository.getById(author.getId())).thenReturn(author);
        when(genreRepository.getById(genre.getId())).thenReturn(genre);

        Book resultBook = bookService.createBook(1, author.getId(), genre.getId(), bookName);

        assertThat(resultBook).isNotNull();
        assertThat(resultBook.getBookName()).isEqualTo(bookName);
        assertThat(resultBook.getAuthor().getId()).isEqualTo(author.getId());
        assertThat(resultBook.getGenre()).isEqualTo(genre);
        verify(bookRepository).create(any(Book.class));
        verify(authorRepository).getById(author.getId());
        verify(genreRepository).getById(genre.getId());
        verifyNoMoreInteractions(bookRepository);
        verifyNoMoreInteractions(authorRepository);
        verifyNoMoreInteractions(genreRepository);
    }
}
