package ru.otus.spring.service;

import ru.otus.spring.entity.Book;

import java.util.List;

public interface BookService {
    Book createBook(Long genreId, Long authorId, String bookName) throws Exception;
    Book deleteBook(Long id) throws Exception;
    Book findById(Long id) throws Exception;
    List<Book> findByGenre(Long genreId) throws Exception;
    List<Book> findByAuthor(Long authorId) throws Exception;
    List<Book> findAll();
}
