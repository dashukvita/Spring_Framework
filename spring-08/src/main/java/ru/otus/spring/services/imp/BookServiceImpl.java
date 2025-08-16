package ru.otus.spring.services.imp;

import ru.otus.spring.entities.Author;
import ru.otus.spring.entities.Genre;
import ru.otus.spring.entities.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.exceptions.AuthorNotFoundException;
import ru.otus.spring.exceptions.BookNotFoundException;
import ru.otus.spring.exceptions.GenreNotFoundException;
import ru.otus.spring.repositories.AuthorRepository;
import ru.otus.spring.repositories.BookRepository;
import ru.otus.spring.services.BookService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
//
//    private final AuthorRepository authorRepository;
//    private final BookRepository bookRepository;
////    private final GenreRepository genreRepository;
//
//    @Override
//    public Book createBook(String genreId, String authorId, String bookName) {
////        authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException("Author with id " + authorId + " not found."));
////        genreRepository.findById(genreId).orElseThrow(() -> new GenreNotFoundException("Genre with id " + genreId + " not found."));
////
////        Book book = Book.builder()
////                .authorId(authorId)
////                .genreId(genreId)
////                .bookName(bookName)
////                .build();
////
////        bookRepository.save(book);
//        return book;
//    }
//
//    @Override
//    public void deleteBook(String id) {
//        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found."));
//        bookRepository.delete(book);
//    }
//
//    @Override
//    public Optional<Book> findById(String id) {
//        return bookRepository.findById(id);
//    }
//
////    @Override
////    public List<Book> findByGenre(String genreId) {
////        Genre genre = genreRepository.findById(genreId).orElseThrow(() -> new GenreNotFoundException("Genre with id " + genreId + " not found."));
////        return null;
////    }
//
//    @Override
//    public List<Book> findByAuthor(String authorId) {
//        Author author = authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException("Author with id " + authorId + " not found."));
//        return null;
//    }
//
//    @Override
//    public List<Book> findAll() {
//        return bookRepository.findAll();
//    }
}
