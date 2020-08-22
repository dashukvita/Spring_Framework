package ru.otus.spring.services;

import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.domain.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.Book;
import ru.otus.spring.repositories.impl.AuthorRepository;
import ru.otus.spring.repositories.impl.BookRepository;
import ru.otus.spring.services.imp.AuthorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public Author save(String firstName, String lastName, String birthday){
        Author author = new Author()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setBirthday(birthday);

        return authorRepository.save(author);
    }

    @Override
    public Author remove(long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(String.format("Автор с id '%s' не найден", id)));

        authorRepository.delete(author);
        return author;
    }

    @Override
    public Author findById(long id)  {
        return authorRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(String.format("Автор с id '%s' не найден", id)));
    }

    @Override
    public Author findByLastName(String lastName) throws Exception {
        Author author = authorRepository.findByLastName(lastName);

        if(author == null){
            throw new Exception(String.format("Автор '%s' не найден", lastName));
        } else {
            return author;
        }
    }

    @Override
    public List<Author> findAll(){
        return authorRepository.findAll();
    }
}
