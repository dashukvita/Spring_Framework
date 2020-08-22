package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.domain.Author;
import ru.otus.spring.services.imp.AuthorService;

@ShellComponent
@RequiredArgsConstructor
public class AuthorCommand {
    private final AuthorService authorService;

    @ShellMethod(value = "Get author by id", key = {"get-author-id", "GA"})
    public void getAuthorById(@ShellOption long id) {
        Author author = authorService.findById(id);
        System.out.printf("%s  %s %s дата рождения %s\n",
                author.getId(),
                author.getFirstName(),
                author.getLastName(),
                author.getBirthday());
    }

    @ShellMethod(value = "Get author by lastName", key = {"get-author-lastname", "AL"})
    public void getAuthorByLastName(@ShellOption String lastName) throws Exception {
        Author author = authorService.findByLastName(lastName);
        System.out.printf("%s  %s %s дата рождения %s\n",
                author.getId(),
                author.getFirstName(),
                author.getLastName(),
                author.getBirthday());
    }

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
        Author author = authorService.save(firstName, lastName, birthDay);
        System.out.printf("Автор %s %s добавлен\n",
                author.getFirstName(),
                author.getLastName());
    }

    @ShellMethod(value = "Delete author", key = {"delete-author", "DA"})
    public void deleteAuthor(@ShellOption long id) {
        Author author = authorService.remove(id);
        System.out.printf("Автор %s %s и его книги удалены из таблицы.\n",
                author.getFirstName(),
                author.getLastName());
    }
}
