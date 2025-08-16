package ru.otus.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.entity.Author;
import ru.otus.spring.exception.AuthorNotFoundException;
import ru.otus.spring.service.AuthorService;

import java.util.Optional;

@ShellComponent
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @ShellMethod(value = "Get all authors", key = {"get-all-authors", "A"})
    public void getAllAuthors() {
        authorService.findAll().forEach(author ->
                System.out.printf("%s  %s %s дата рождения %s\n",
                        author.getId(),
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBirthday()));
    }

    @ShellMethod(value = "Create author", key = {"create-author", "CA"})
    public void createAuthor(@ShellOption String firstName,
                             @ShellOption String lastName,
                             @ShellOption String birthDay) {
        Author author = authorService.createAuthor(firstName, lastName, birthDay);
        System.out.printf("Автор %s %s добавлен\n",
                author.getFirstName(),
                author.getLastName());
    }

    @ShellMethod(value = "Get author by id", key = {"get-author-id", "GA"})
    public void getAuthorById(@ShellOption String id) {
        Optional<Author> author = authorService.findById(id);

        if (author.isPresent()) {
            System.out.printf("%s  %s %s дата рождения %s\n",
                    author.get().getId(),
                    author.get().getFirstName(),
                    author.get().getLastName(),
                    author.get().getBirthday());
        } else {
            System.out.println("Author with id " + id + " not found.");
        }
    }

    @ShellMethod(value = "Delete author", key = {"delete-author", "DA"})
    public void deleteAuthor(@ShellOption String id) {
        Author author = authorService.findById(id).orElseThrow(() -> new AuthorNotFoundException("Author with id " + id + " not found."));

        authorService.deleteAuthor(id);
        System.out.printf("Автор %s %s и его книги удалены из таблицы.\n",
                author.getFirstName(),
                author.getLastName());
    }
}
