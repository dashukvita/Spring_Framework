package ru.otus.spring.services.imp;

import ru.otus.spring.domain.Author;

import java.util.List;

public interface AuthorService {

    Author save(String firstName, String lastName, String birthday);

    Author remove(long id);

    Author findById(long id);

    Author findByLastName(String lastName) throws Exception;

    List<Author> findAll();
}
