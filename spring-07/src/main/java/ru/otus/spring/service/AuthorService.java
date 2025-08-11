package ru.otus.spring.service;

import ru.otus.spring.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author createAuthor(String firstName, String lastName, String birthday);
    void deleteAuthor(Long id);
    Optional<Author> findById(Long id);
    List<Author> findAll();
}
