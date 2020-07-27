package ru.otus.spring.dao.impl;

import ru.otus.spring.domain.Author;

import java.util.List;

public interface AuthorDao {

    void create(Author author);

    void deleteById(long id);

    Author getById(long id);

    List<Author> getAll();

}
