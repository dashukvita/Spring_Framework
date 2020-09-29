package ru.otus.spring.repositories.impl;

import ru.otus.spring.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {

    Author save(Author author);

    void remove(Author author);

    Author findById(long id);

    List<Author> findAll();

}
