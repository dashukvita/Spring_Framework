package ru.otus.spring.dao.impl;

import ru.otus.spring.domain.Book;

import java.util.List;

public interface BookDao {

    void create(Book book);

    void deleteById(long id);

    Book getById(long id);

    List<Book> getByGenre(long genreId);

    List<Book> getByAuthor(long authorId);

    List<Book> getAll();

    int count();
}
