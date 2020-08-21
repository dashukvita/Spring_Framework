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

@DisplayName("Класс BookServiceImpl")
public class BookServiceImplTest {

//    private AuthorRepository authorRepository;
//    private BookRepository bookRepository;
//    private GenreRepository genreRepository;
//    private BookService bookService;
//
//    @BeforeEach
//    void setUp() {
//        authorRepository = mock(AuthorRepository.class);
//        bookRepository = mock(BookRepository.class);
//        genreRepository = mock(GenreRepository.class);
//
//        bookService = new BookServiceImpl(authorRepository, bookRepository, genreRepository);
//    }
//
//    @Test
//    @DisplayName("получение книги по id из бд корректно")
//    void getBook() throws Exception {
//        long id = 3;
//        String bookName = "Book3";
//        Book book = new Book()
//                .setGenre(genreRepository.findById(1))
//                .setAuthor(authorRepository.findById(1))
//                .setBookName(bookName);
//        when(bookRepository.findById(id)).thenReturn(book);
//
//        Book resultBook = bookService.findByIdBook(id);
//
//        assertThat(resultBook).isNotNull();
//        assertThat(resultBook).isEqualTo(book);
//        verify(bookRepository).findById(id);
//        verifyNoMoreInteractions(bookRepository);
//    }
//
//    @Test
//    @DisplayName("получение всех книг из бд корректно")
//    void getAllBooks() {
//        ArrayList<Book> books = new ArrayList<>();
//        when(bookRepository.findAll()).thenReturn(books);
//
//        List<Book> allBooks = bookService.findAllBooks();
//
//        assertThat(allBooks).isNotNull();
//        assertThat(allBooks).isEqualTo(books);
//        verify(bookRepository).findAll();
//        verifyNoMoreInteractions(bookRepository);
//    }
//
//    @Test
//    @DisplayName("создание книги корректно")
//    void createBook() throws Exception {
//        String firstName = "Author3";
//        String lastName = "Author3";
//        String birthDay = "05.01.1932";
//
//        String genreName = "Genre3";
//        String codeGenre = "G3";
//
//        String bookName = "BookTest";
//
//        Genre genre = new Genre();
//        genre.setCodeGenre(codeGenre);
//        genre.setGenreName(genreName);
//
//        Author author = new Author();
//        author.setFirstName(firstName);
//        author.setLastName(lastName);
//        author.setBirthday(birthDay);
//
//        when(authorRepository.findById(author.getId())).thenReturn(author);
//        when(genreRepository.findById(genre.getId())).thenReturn(genre);
//
//        Book resultBook = bookService.saveBook(genre.getId(), author.getId(), bookName);
//
//        assertThat(resultBook).isNotNull();
//        assertThat(resultBook.getBookName()).isEqualTo(bookName);
//        assertThat(resultBook.getAuthor().getId()).isEqualTo(author.getId());
//        assertThat(resultBook.getGenre()).isEqualTo(genre);
//        verify(bookRepository).save(any(Book.class));
//        verify(authorRepository).findById(author.getId());
//        verify(genreRepository).findById(genre.getId());
//        verifyNoMoreInteractions(bookRepository);
//        verifyNoMoreInteractions(authorRepository);
//        verifyNoMoreInteractions(genreRepository);
//    }
//
//    @Test
//    @DisplayName("удаление книги из бд корректно")
//    void deleteBook() throws Exception {
//        int id = 1;
//        Book book = new Book()
//                .setId(id);
//
//        when(bookRepository.findById(id)).thenReturn(book);
//
//        Book resultBook = bookService.removeBook(id);
//
//        assertThat(resultBook).isNotNull();
//        assertThat(resultBook.getId()).isEqualTo(id);
//
//        verify(bookRepository).findById(id);
//        verify(bookRepository).remove(book);
//
//        verifyNoMoreInteractions(bookRepository);
//        verifyNoMoreInteractions(authorRepository);
//    }
}
