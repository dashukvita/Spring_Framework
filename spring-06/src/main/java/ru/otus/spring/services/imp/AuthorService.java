package ru.otus.spring.services.imp;

import ru.otus.spring.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Author createAuthor(long author_id, String firstName, String lastname, String birthday);

    Optional<Author> removeAuthor(long id);

    Author getByIdAuthor(long id);

    List<Author> getAllAuthors();
}
