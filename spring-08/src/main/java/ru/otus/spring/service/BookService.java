package ru.otus.spring.service;

import ru.otus.spring.entity.Author;
import ru.otus.spring.entity.Book;
import ru.otus.spring.entity.Genre;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book createBook(String genreId, String authorId, String bookName);
    void deleteBook(String id);
    Optional<Book> findById(String id);
    List<Book> findByGenre(String genreId);
    List<Book> findByAuthor(String authorId);
    List<Book> findAll();
}
