package ru.otus.spring.services;

import ru.otus.spring.entities.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author createAuthor(String firstName, String lastName, String birthday);
    void deleteAuthor(String id);
    Optional<Author> findById(String id);
    List<Author> findAll();
}
