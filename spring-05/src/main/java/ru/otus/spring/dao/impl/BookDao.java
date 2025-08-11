package ru.otus.spring.dao.impl;

import ru.otus.spring.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    Book create(Book book);

    void deleteById(long id);

    Optional<Book> getById(long id);

    List<Book> getByGenre(long genreId);

    List<Book> getByAuthor(long authorId);

    List<Book> getAll();

}
