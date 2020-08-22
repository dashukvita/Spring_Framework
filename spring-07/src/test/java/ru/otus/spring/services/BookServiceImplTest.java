package ru.otus.spring.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.repositories.impl.AuthorRepository;
import ru.otus.spring.repositories.impl.BookRepository;
import ru.otus.spring.repositories.impl.CommentRepository;
import ru.otus.spring.repositories.impl.GenreRepository;
import ru.otus.spring.services.imp.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@DisplayName("Класс BookServiceImpl")
public class BookServiceImplTest {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private GenreRepository genreRepository;
    private CommentRepository commentRepository;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        authorRepository = mock(AuthorRepository.class);
        bookRepository = mock(BookRepository.class);
        genreRepository = mock(GenreRepository.class);
        commentRepository = mock(CommentRepository.class);

        bookService = new BookServiceImpl(authorRepository, bookRepository, genreRepository, commentRepository);
    }

    @Test
    @DisplayName("получение книги по id из бд корректно")
    void getBook() {
        long id = 1;
        Book book = new Book()
                .setId(id);

        when(bookRepository.findById(id)).thenReturn(Optional.ofNullable(book));

        Book resultBook = bookService.findById(id);

        assertThat(resultBook).isNotNull();
        assertThat(resultBook).isEqualTo(book);
        verify(bookRepository).findById(id);
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    @DisplayName("получение всех книг из бд корректно")
    void getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> allBooks = bookService.findAll();

        assertThat(allBooks).isNotNull();
        assertThat(allBooks).isEqualTo(books);
        verify(bookRepository).findAll();
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    @DisplayName("создание книги корректно")
    void createBook()  {
        String firstName = "Author3";
        String lastName = "Author3";
        String birthDay = "05.01.1932";

        String title = "Genre3";
        String code = "G3";

        String bookName = "BookTest";

        Genre genre = new Genre()
                .setCode(title)
                .setTitle(code);

        Author author = new Author()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setBirthday(birthDay);

        Book book = new Book()
                .setTitle(bookName)
                .setAuthor(author)
                .setGenre(genre);

        when(authorRepository.findById(author.getId())).thenReturn(java.util.Optional.of(author));
        when(genreRepository.findById(genre.getId())).thenReturn(java.util.Optional.of(genre));

        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book resultBook = bookService.save(genre.getId(), author.getId(), bookName);

        assertThat(resultBook).isNotNull();
        assertThat(resultBook.getTitle()).isEqualTo(bookName);
        assertThat(resultBook.getAuthor().getId()).isEqualTo(author.getId());
        assertThat(resultBook.getGenre()).isEqualTo(genre);

        verify(bookRepository).save(any(Book.class));
        verify(authorRepository).findById(author.getId());
        verify(genreRepository).findById(genre.getId());

        verifyNoMoreInteractions(bookRepository);
        verifyNoMoreInteractions(authorRepository);
        verifyNoMoreInteractions(genreRepository);
    }

    @Test
    @DisplayName("удаление книги из бд корректно")
    void deleteBook() {
        long id = 1;
        Book book = new Book()
                .setId(id);

        when(bookRepository.findById(id)).thenReturn(Optional.ofNullable(book));

        Book resultBook = bookService.remove(id);

        assertThat(resultBook).isNotNull();
        assertThat(resultBook.getId()).isEqualTo(id);

        verify(bookRepository).findById(id);
        verify(bookRepository).delete(book);

        verifyNoMoreInteractions(bookRepository);
        verifyNoMoreInteractions(authorRepository);
    }
}
