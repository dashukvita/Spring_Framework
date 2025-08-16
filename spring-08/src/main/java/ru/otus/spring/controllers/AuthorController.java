package ru.otus.spring.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.entities.Author;
import ru.otus.spring.exceptions.AuthorNotFoundException;
import ru.otus.spring.services.AuthorService;

import java.util.Optional;

@ShellComponent
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @ShellMethod(value = "Get all authors", key = {"get-all-authors", "A"})
    public void getAllAuthors() {
        authorService.findAll().forEach(author ->
                System.out.printf("%s  %s %s date of birth %s\n",
                        author.getId(),
                        author.getName(),
                        author.getSurname(),
                        author.getBirthday()));
    }

    @ShellMethod(value = "Create author", key = {"create-author", "CA"})
    public void createAuthor(@ShellOption(help = "enter author name") String name,
                             @ShellOption(help = "enter author surname") String surname,
                             @ShellOption(help = "enter author birthDay") String birthDay) {
        Author author = authorService.createAuthor(name, surname, birthDay);
        System.out.printf("Author %s %s has been added.\n",
                author.getName(),
                author.getSurname());
    }

    @ShellMethod(value = "Get author by id", key = {"get-author-id", "GA"})
    public void getAuthorById(@ShellOption String id) {
        Optional<Author> author = authorService.findById(id);

        if (author.isPresent()) {
            System.out.printf("%s %s date of birth %s\n",
                    author.get().getName(),
                    author.get().getSurname(),
                    author.get().getBirthday());
        } else {
            System.out.println("Author with id " + id + "was not found.\n");
        }
    }

    @ShellMethod(value = "Delete author", key = {"delete-author", "DA"})
    public void deleteAuthor(@ShellOption String id) {
        Author author = authorService.findById(id).orElseThrow(() -> new AuthorNotFoundException("Author with id " + id + " not found.\n"));

        authorService.deleteAuthor(id);
        System.out.printf("Author %s %s and his books have been removed from the table.\n",
                author.getName(),
                author.getSurname());
    }
}
