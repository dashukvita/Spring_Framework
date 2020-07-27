package ru.otus.spring.services;

import org.springframework.stereotype.Repository;
import ru.otus.spring.dao.impl.AuthorDao;
import ru.otus.spring.domain.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.services.imp.AuthorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;

    @Override
    public Author createAuthor(long id, String firstName, String lastname, String birthday){
        Author author = new Author(id, firstName, lastname, birthday);
        authorDao.create(author);
        return author;
    }

    @Override
    public Author deleteAuthor(long id){
        Author author = authorDao.getById(id);
        authorDao.deleteById(id);
        return author;
    }

    @Override
    public Author getByIdAuthor(long id){
        return authorDao.getById(id);
    }

    @Override
    public List<Author> getAllAuthors(){
        return authorDao.getAll();
    }
}
