package ru.otus.spring.repository.impl;

import ru.otus.spring.entity.Author;

import java.util.List;

public interface AuthorRepository {

    Author save(Author author);

    void remove(Author author);

    Author findById(long id);

    List<Author> findAll();

}
