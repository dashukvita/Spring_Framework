package ru.otus.spring.services;

import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.repositories.impl.AuthorRepository;
import ru.otus.spring.domain.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.services.imp.AuthorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    @Transactional
    public Author saveAuthor(String firstName, String lastname, String birthday){
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastname);
        author.setBirthday(birthday);

        authorRepository.save(author);
        return author;
    }

    @Override
    @Transactional
    public Author removeAuthor(long id) throws Exception {
        Author author = authorRepository.findById(id);

        if(author == null){
            throw new Exception(String.format("Автора с id '%s' нет в базе", id));
        } else{
            authorRepository.remove(author);
            return author;
        }
    }

    @Override
    @Transactional
    public Author findByIdAuthor(long id)  throws Exception {
        Author author = authorRepository.findById(id);

        if(author == null){
            throw new Exception(String.format("Автор с id '%s' не найден", id));
        } else {
            return author;
        }
    }

    @Override
    @Transactional
    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }
}
