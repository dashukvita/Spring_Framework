package ru.otus.spring.repositories.impl;

import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

import java.util.List;

public interface BookRepository {

    Book save(Book book);

    void remove(Book book);

    Book findById(long id);

    Book findByGenre(Genre genre);

    Book findByAuthor(Author author);

    List<Book> findAll();
}
