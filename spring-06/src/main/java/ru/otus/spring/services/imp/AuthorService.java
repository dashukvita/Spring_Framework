package ru.otus.spring.services.imp;

import ru.otus.spring.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Author saveAuthor(String firstName, String lastname, String birthday);

    Author removeAuthor(long id);

    Author findByIdAuthor(long id);

    List<Author> findAllAuthors();
}
