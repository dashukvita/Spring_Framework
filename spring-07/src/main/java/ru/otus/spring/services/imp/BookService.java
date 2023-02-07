package ru.otus.spring.services.imp;

import ru.otus.spring.domain.Book;

import java.util.List;

public interface BookService {

    Book save(long genreId, long authorId, String title);

    Book remove(long id);

    Book findById(long id);

    List<Book> findByGenre(long genreId);

    List<Book> findByAuthor(long authorId);

    List<Book> findAll();
}
