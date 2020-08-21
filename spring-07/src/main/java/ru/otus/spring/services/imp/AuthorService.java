package ru.otus.spring.services.imp;

import ru.otus.spring.domain.Author;

import java.util.List;

public interface AuthorService {

    Author saveAuthor(String firstName, String lastname, String birthday);

    Author removeAuthor(long id) throws Exception;

    Author findByIdAuthor(long id) throws Exception;

    List<Author> findAllAuthors();
}
