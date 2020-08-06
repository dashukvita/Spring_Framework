package ru.otus.spring.dao.impl;

import ru.otus.spring.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {

    Author create(Author author);

    void deleteById(long id);

    Optional<Author> getById(long id);

    List<Author> getAll();

}
