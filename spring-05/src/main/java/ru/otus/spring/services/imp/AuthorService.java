package ru.otus.spring.services.imp;

import ru.otus.spring.domain.Author;

import java.util.List;

public interface AuthorService {

    Author createAuthor(long author_id, String firstName, String lastname, String birthday);

    Author deleteAuthor(long id);

    Author getByIdAuthor(long id);

    List<Author> getAllAuthors();
}
