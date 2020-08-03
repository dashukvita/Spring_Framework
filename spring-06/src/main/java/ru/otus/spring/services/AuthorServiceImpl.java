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
    public Author saveAuthor(String firstName, String lastname, String birthday){
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastname);
        author.setBirthday(birthday);

        authorRepository.save(author);
        return author;
    }

    @Override
    public Author removeAuthor(long id){
        Author author = authorRepository.findById(id);
        if(author != null){
            authorRepository.remove(author);
        }
        return author;
    }

    @Override
    public Author findByIdAuthor(long id){
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }
}
