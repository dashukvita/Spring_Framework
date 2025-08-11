package ru.otus.spring.service.imp;

import ru.otus.spring.entity.Author;

import java.util.List;

public interface AuthorService {

    Author saveAuthor(String firstName, String lastname, String birthday);

    Author removeAuthor(long id) throws Exception;

    Author findByIdAuthor(long id) throws Exception;

    List<Author> findAllAuthors();
}
