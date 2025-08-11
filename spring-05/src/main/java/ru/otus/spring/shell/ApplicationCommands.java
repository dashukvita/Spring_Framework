package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.entity.Author;
import ru.otus.spring.entity.Book;
import ru.otus.spring.entity.Genre;
import ru.otus.spring.service.imp.AuthorService;
import ru.otus.spring.service.imp.BookService;
import ru.otus.spring.service.imp.GenreService;

import java.util.Optional;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationCommands {

    private final AuthorService authorService;
    private final GenreService genreService;
    private final BookService bookService;

    @ShellMethod(value = "Get all books", key = {"get-all-books", "B"})
    public void getAllBooks() {
        bookService.getAllBooks().forEach(book ->
                System.out.printf("%s  '%s.'    Автор: %s %s    Жанр: %s\n",
                        book.getId(),
                        book.getBookName(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName(),
                        book.getGenre().getGenre()));
    }

    @ShellMethod(value = "Get book by author", key = {"get-books-by-author", "BA"})
    public void getBookByAuthor(@ShellOption long authorId) {
        bookService.getByAuthorBook(authorId).forEach(book ->
                System.out.printf("%s  '%s.'    Автор: %s %s    Жанр: %s\n",
                        book.getId(),
                        book.getBookName(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName(),
                        book.getGenre().getGenre()));
    }

    @ShellMethod(value = "Get book by genre", key = {"get-books-by-genre", "BG"})
    public void getBookByGenre(@ShellOption long genreId) {
        bookService.getByGenreBook(genreId).forEach(book ->
                System.out.printf("%s  '%s.'    Автор: %s %s    Жанр: %s\n",
                        book.getId(),
                        book.getBookName(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName(),
                        book.getGenre().getGenre()));
    }

    @ShellMethod(value = "Get all authors", key = {"get-all-authors", "A"})
    public void getAllAuthors() {
        authorService.getAllAuthors().forEach(author ->
                System.out.printf("%s  %s %s дата рождения %s\n",
                        author.getId(),
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBirthday()));
    }

    @ShellMethod(value = "Get all genres", key = {"get-all-genre", "G"})
    public void getAllGenre() {
        genreService.getAllGenres().forEach(genre ->
                System.out.printf("%s  %s \n",
                        genre.getId(),
                        genre.getGenre()));
    }

    @ShellMethod(value = "Delete book", key = {"delete-book", "DB"})
    public void deleteBook(@ShellOption long id) {
        Optional<Book> book = bookService.deleteBook(id);
        System.out.printf("Книга удалена: %s, Автор %s\n",
                book.get().getBookName(),
                book.get().getAuthor().getLastName(),
                book.get().getAuthor().getFirstName());
    }

    @ShellMethod(value = "Delete author", key = {"delete-author", "DA"})
    public void deleteAuthor(@ShellOption long id) {
        Optional<Author> author = authorService.deleteAuthor(id);
        System.out.printf("Автор %s %s и его книги удалены из таблицы.\n",
                author.get().getFirstName(),
                author.get().getLastName());
    }

    @ShellMethod(value = "Delete genre", key = {"delete-genre", "DG"})
    public void deleteGenre(@ShellOption long id) {
        Optional<Genre> genre = genreService.deleteGenre(id);
        System.out.printf("Жанр %s и книги этого жанра удалены.\n",
                genre.get().getGenre());
    }

    @ShellMethod(value = "Create book", key = {"create-book", "CB"})
    public void createBook(@ShellOption long idAuthor,
                           @ShellOption long idGenre,
                           @ShellOption String bookName) {
        Book book = bookService.createBook(idAuthor, idGenre, bookName);
        System.out.printf("Книга добавлена: %s, Автор %s %s\n",
                book.getBookName(),
                book.getAuthor().getFirstName(),
                book.getAuthor().getLastName());
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

    @ShellMethod(value = "Create genre", key = {"create-genre", "CG"})
    public void createGenre(@ShellOption String codeGenre,
                             @ShellOption String genreName) {
        Genre genre = genreService.createGenre(codeGenre, genreName);
        System.out.printf("Жанр %s добавлен\n",
                genre.getGenre());
    }

    @ShellMethod(value = "Get book", key = {"get-book", "GB"})
    public void getBookById(@ShellOption long id) {
        Optional<Book> book = bookService.getByIdBook(id);
        System.out.printf("%s  '%s.'    Автор: %s %s    Жанр: %s\n",
                book.get().getId(),
                book.get().getBookName(),
                book.get().getAuthor().getFirstName(),
                book.get().getAuthor().getLastName(),
                book.get().getGenre().getGenre());
    }

    @ShellMethod(value = "Get author by id", key = {"get-author-id", "GA"})
    public void getAuthorById(@ShellOption long id) {
        Optional<Author> author = authorService.getByIdAuthor(id);
        System.out.printf("%s  %s %s дата рождения %s\n",
                author.get().getId(),
                author.get().getFirstName(),
                author.get().getLastName(),
                author.get().getBirthday());
    }

    @ShellMethod(value = "Get genre by id", key = {"get-genre-id", "GG"})
    public void getGenreById(@ShellOption long id) {
        Optional<Genre> genre = genreService.getByIdGenre(id);
        System.out.printf("%s  %s \n",
                genre.get().getId(),
                genre.get().getGenre());
    }

}
