package ru.otus.spring.service;

import ru.otus.spring.dao.impl.AuthorDao;
import ru.otus.spring.entity.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.service.imp.AuthorService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;

    @Override
    public Author createAuthor(String firstName, String lastname, String birthday){
        Author author = Author.builder().firstName(firstName).lastName(lastname).birthday(birthday).build();
        authorDao.create(author);

        return author;
    }

    @Override
    public Optional<Author> deleteAuthor(long id){
        Optional<Author> author = authorDao.getById(id);
        authorDao.deleteById(id);
        return author;
    }

    @Override
    public Optional<Author> getByIdAuthor(long id){
        return authorDao.getById(id);
    }

    @Override
    public List<Author> getAllAuthors(){
        return authorDao.getAll();
    }
}
