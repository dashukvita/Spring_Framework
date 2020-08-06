package ru.otus.spring.services.imp;

import ru.otus.spring.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Author createAuthor(String firstName, String lastname, String birthday);

    Optional<Author> deleteAuthor(long id);

    Optional<Author> getByIdAuthor(long id);

    List<Author> getAllAuthors();
}
