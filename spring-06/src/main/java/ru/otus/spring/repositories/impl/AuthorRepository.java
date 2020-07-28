package ru.otus.spring.repositories.impl;

import ru.otus.spring.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {

    Author save(Author author);

    void remove(Optional<Author> author);

    Optional<Author> findById(long id);

    List<Author> findAll();

}
