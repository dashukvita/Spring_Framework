package ru.otus.spring.service;

import ru.otus.spring.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book createBook(Long genreId, Long authorId, String bookName);
    void deleteBook(Long id);
    Optional<Book> findById(Long id);
    List<Book> findByGenre(Long genreId);
    List<Book> findByAuthor(Long authorId);
    List<Book> findAll();
}
