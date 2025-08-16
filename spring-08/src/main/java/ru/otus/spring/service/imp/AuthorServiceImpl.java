package ru.otus.spring.service.imp;

import lombok.AllArgsConstructor;
import ru.otus.spring.entity.Author;
import org.springframework.stereotype.Service;
import ru.otus.spring.exception.AuthorNotFoundException;
import ru.otus.spring.repository.AuthorRepository;
import ru.otus.spring.service.AuthorService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public Author createAuthor(String firstName, String lastName, String birthday) {
        Author author = Author.builder()
                .firstName(firstName)
                .lastName(lastName)
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
