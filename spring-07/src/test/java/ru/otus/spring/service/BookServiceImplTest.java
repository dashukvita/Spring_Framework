package ru.otus.spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.entity.Author;
import ru.otus.spring.entity.Book;
import ru.otus.spring.entity.Genre;
import ru.otus.spring.exception.AuthorNotFoundException;
import ru.otus.spring.exception.BookNotFoundException;
import ru.otus.spring.repository.AuthorRepository;
import ru.otus.spring.repository.BookRepository;
import ru.otus.spring.repository.GenreRepository;
import ru.otus.spring.service.imp.BookServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@DisplayName("BookServiceImpl")
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
    @DisplayName("fetching book by id from db is correct")
    void getBook() throws Exception {
        Long id = 3L;
        String bookName = "Book3";

        Genre genre = new Genre()
                .setId(id);

        Author author = new Author()
                .setId(id);

        Book book = new Book()
                .setGenre(genre)
                .setAuthor(author)
                .setBookName(bookName);

        when(genreRepository.findById(id)).thenReturn(Optional.of(genre));
        when(authorRepository.findById(id)).thenReturn(Optional.of(author));
        when(bookRepository.findById(id)).thenReturn(Optional.of(book));

        Book resultBook = bookService.findById(id).orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found."));

        assertThat(resultBook).isNotNull().isEqualTo(book);
        verify(bookRepository).findById(id);
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    @DisplayName("fetching all books from db is correct")
    void getAllBooks() {
        List<Book> books = List.of(new Book().setId(1L).setBookName("B1"));
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> allBooks = bookService.findAll();

        assertThat(allBooks).isNotNull().hasSize(1).isEqualTo(books);
        verify(bookRepository).findAll();
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    @DisplayName("creating book is correct")
    void createBook() throws Exception {
        String firstName = "Author3";
        String lastName = "Author3";
        String birthDay = "05.01.1932";

        String genreName = "Genre3";
        String codeGenre = "G3";

        String bookName = "BookTest";

        Genre genre = new Genre();
        genre.setCodeGenre(codeGenre);
        genre.setGenreName(genreName);

        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setBirthday(birthDay);

        when(authorRepository.findById(author.getId())).thenReturn(Optional.of(author));
        when(genreRepository.findById(genre.getId())).thenReturn(Optional.of(genre));

        Book resultBook = bookService.createBook(genre.getId(), author.getId(), bookName);

        assertThat(resultBook).isNotNull();
        assertThat(resultBook.getBookName()).isEqualTo(bookName);
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
    @DisplayName("deleting book from db is correct")
    void deleteBook() throws Exception {
        Long id = 1L;
        Book book = new Book()
                .setId(id);

        when(bookRepository.findById(id)).thenReturn(Optional.of(book));

        bookService.deleteBook(id);

        verify(bookRepository).findById(id);
        verify(bookRepository).delete(book);
        verifyNoMoreInteractions(bookRepository, authorRepository, genreRepository);
    }
}
