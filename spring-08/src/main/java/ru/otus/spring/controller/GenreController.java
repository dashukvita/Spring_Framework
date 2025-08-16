package ru.otus.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.entity.Genre;
import ru.otus.spring.exception.GenreNotFoundException;
import ru.otus.spring.service.GenreService;

@ShellComponent
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @ShellMethod(value = "Get all genres", key = {"get-all-genre", "G"})
    public void getAllGenres() {
        genreService.findAll().forEach(genre ->
                System.out.printf("%s  %s \n",
                        genre.getId(),
                        genre.getGenreName()));
    }

    @ShellMethod(value = "Create genre", key = {"create-genre", "CG"})
    public void createGenre(@ShellOption String codeGenre,
                            @ShellOption String genreName) {
        Genre genre = genreService.createGenre(codeGenre, genreName);
        System.out.printf("Жанр %s %s добавлен\n",
                genre.getId(),
                genre.getGenreName());
    }

//    @ShellMethod(value = "Get genre by id", key = {"get-genre-id", "GG"})
//    public void getGenreNameById(@ShellOption Long id) throws Exception {
//        Genre genre = genreService.findById(id)
//                .orElseThrow(() -> new Exception("Genre with id " + id + " not found."));
//
//        System.out.printf("%s  %s \n",
//                genre.getId(),
//                genre.getGenreName());
//    }
//
//    @ShellMethod(value = "Delete genre", key = {"delete-genre", "DG"})
//    public void deleteGenre(@ShellOption Long id) {
//        Genre genre = genreService.findById(id)
//                .orElseThrow(() -> new GenreNotFoundException("Genre with id " + id + " not found."));
//        genreService.deleteGenre(id);
//        System.out.printf("Жанр %s и книги этого жанра удалены.\n",
//                genre.getGenreName());
//    }

}
