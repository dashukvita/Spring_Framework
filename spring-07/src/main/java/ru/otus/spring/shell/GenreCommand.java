package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.services.imp.GenreService;

@ShellComponent
@RequiredArgsConstructor
public class GenreCommand {

    private final GenreService genreService;

    @ShellMethod(value = "Get genre by id", key = {"get-genre-id", "GG"})
    public void getGenreNameById(@ShellOption long id) {
        Genre genre = genreService.findById(id);
        System.out.printf("%s  %s \n",
                genre.getId(),
                genre.getTitle());
    }

    @ShellMethod(value = "Get genre by title", key = {"get-genre-title", "GT"})
    public void getGenreByTitle(@ShellOption String title) throws Exception {
        Genre genre = genreService.findByTitle(title);
        System.out.printf("%s  %s \n",
                genre.getId(),
                genre.getTitle());
    }

    @ShellMethod(value = "Get all genres", key = {"get-all-genre", "G"})
    public void getAllGenres() {
        genreService.findAllGenres().forEach(genre ->
                System.out.printf("%s  %s \n",
                        genre.getId(),
                        genre.getTitle()));
    }

    @ShellMethod(value = "Create genre", key = {"create-genre", "CG"})
    public void createGenre(@ShellOption String code,
                            @ShellOption String title) {
        Genre genre = genreService.save(code, title);
        System.out.printf("Жанр %s %s добавлен\n",
                genre.getId(),
                genre.getTitle());
    }

    @ShellMethod(value = "Delete genre", key = {"delete-genre", "DG"})
    public void deleteGenre(@ShellOption long id) {
        Genre genre = genreService.remove(id);
        System.out.printf("Жанр %s и книги этого жанра удалены.\n",
                genre.getTitle());
    }
}
