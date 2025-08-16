package ru.otus.spring.service.imp;

import ru.otus.spring.entity.Author;
import ru.otus.spring.entity.Genre;
import ru.otus.spring.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.exception.AuthorNotFoundException;
import ru.otus.spring.exception.BookNotFoundException;
import ru.otus.spring.exception.GenreNotFoundException;
import ru.otus.spring.repository.AuthorRepository;
import ru.otus.spring.repository.BookRepository;
import ru.otus.spring.repository.GenreRepository;
import ru.otus.spring.service.BookService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    @Override
    public Book createBook(String genreId, String authorId, String bookName) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException("Author with id " + authorId + " not found."));
        Genre genre = genreRepository.findById(genreId).orElseThrow(() -> new GenreNotFoundException("Genre with id " + genreId + " not found."));

        Book book = new Book()
                .setGenre(genre)
                .setAuthor(author)
                .setBookName(bookName);

        bookRepository.save(book);
        return book;
    }

    @Override
    public void deleteBook(String id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found."));
        bookRepository.delete(book);
    }

    @Override
    public Optional<Book> findById(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findByGenre(String genreId) {
        Genre genre = genreRepository.findById(genreId).orElseThrow(() -> new GenreNotFoundException("Genre with id " + genreId + " not found."));
        return bookRepository.findByGenre(genre);
    }

    @Override
    public List<Book> findByAuthor(String authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException("Author with id " + authorId + " not found."));
        return bookRepository.findByAuthor(author);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
