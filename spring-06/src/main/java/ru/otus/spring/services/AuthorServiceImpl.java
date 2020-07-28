package ru.otus.spring.services;

import ru.otus.spring.repositories.impl.AuthorRepository;
import ru.otus.spring.domain.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.services.imp.AuthorService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author createAuthor(long id, String firstName, String lastname, String birthday){
        Author author = new Author(id, firstName, lastname, birthday);
        authorRepository.save(author);
        return author;
    }

    @Override
    public Optional<Author> removeAuthor(long id){
        Optional<Author> author = authorRepository.findById(id);
        authorRepository.remove(author);
        return author;
    }

    @Override
    public Author getByIdAuthor(long id){
        return authorRepository.getById(id);
    }

    @Override
    public List<Author> getAllAuthors(){
        return authorRepository.getAll();
    }
}
