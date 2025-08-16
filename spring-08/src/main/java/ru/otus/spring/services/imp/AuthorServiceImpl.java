package ru.otus.spring.services.imp;

import lombok.AllArgsConstructor;
import ru.otus.spring.entities.Author;
import org.springframework.stereotype.Service;
import ru.otus.spring.exceptions.AuthorNotFoundException;
import ru.otus.spring.repositories.AuthorRepository;
import ru.otus.spring.services.AuthorService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public Author createAuthor(String firstName, String lastName, String birthday) {
        Author author = Author.builder()
                .name(firstName)
                .surname(lastName)
                .birthday(birthday)
                .build();

        authorRepository.save(author);
        return author;
    }
    @Override
    public void deleteAuthor(String id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("Author with id " + id + " not found."));
        authorRepository.delete(author);
    }
    @Override
    public Optional<Author> findById(String id) {
        return authorRepository.findById(id);
    }
    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
