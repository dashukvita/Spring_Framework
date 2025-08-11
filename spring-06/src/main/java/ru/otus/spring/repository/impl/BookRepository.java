package ru.otus.spring.repository.impl;

import ru.otus.spring.entity.Author;
import ru.otus.spring.entity.Book;
import ru.otus.spring.entity.Genre;

import java.util.List;

public interface BookRepository {

    Book save(Book book);

    void remove(Book book);

    Book findById(long id);

    Book findByGenre(Genre genre);

    Book findByAuthor(Author author);

    List<Book> findAll();
}
