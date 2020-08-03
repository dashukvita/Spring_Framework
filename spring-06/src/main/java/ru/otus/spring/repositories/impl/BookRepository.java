package ru.otus.spring.repositories.impl;

import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Book save(Book book);

    void remove(Optional<Book> book);

    Book findById(long id);

    List<Book> findByGenre(Genre genre);

    List<Book> findByAuthor(Optional<Author> author);

    List<Book> findAll();
}
