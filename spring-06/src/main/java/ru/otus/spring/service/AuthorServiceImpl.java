package ru.otus.spring.service;

import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.repository.impl.AuthorRepository;
import ru.otus.spring.entity.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.service.imp.AuthorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    @Transactional
    public Author saveAuthor(String firstName, String lastname, String birthday){
        Author author = new Author()
                .setFirstName(firstName)
                .setLastName(lastname)
                .setBirthday(birthday);

        authorRepository.save(author);
        return author;
    }

    @Override
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
    public Author findByIdAuthor(long id)  throws Exception {
        Author author = authorRepository.findById(id);

        if(author == null){
            throw new Exception(String.format("Автор с id '%s' не найден", id));
        } else {
            return author;
        }
    }

    @Override
    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }
}
