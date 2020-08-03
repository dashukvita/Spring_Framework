package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.services.imp.AuthorService;
import ru.otus.spring.services.imp.BookService;
import ru.otus.spring.services.imp.CommentService;
import ru.otus.spring.services.imp.GenreService;

import java.util.Optional;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationCommands {

    private final AuthorService authorService;
    private final GenreService genreService;
    private final BookService bookService;
    private final CommentService commentService;

    @ShellMethod(value = "Get all authors", key = {"get-all-authors", "A"})
    public void getAllAuthors() {
        authorService.findAllAuthors().forEach(author ->
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
        Author author = authorService.saveAuthor(firstName, lastName, birthDay);
        System.out.printf("Автор %s %s добавлен\n",
                author.getFirstName(),
                author.getLastName());
    }

    @ShellMethod(value = "Get author by id", key = {"get-author-id", "GAI"})
    public void getAuthorById(@ShellOption long id) {
        Optional<Author> author = Optional.ofNullable(authorService.findByIdAuthor(id));
        System.out.printf("%s  %s %s дата рождения %s\n",
                author.get().getId(),
                author.get().getFirstName(),
                author.get().getLastName(),
                author.get().getBirthday());
    }

    @ShellMethod(value = "Delete author", key = {"delete-author", "DA"})
    public void deleteAuthor(@ShellOption long id) {
        Optional<Author> author = Optional.ofNullable(authorService.removeAuthor(id));
        System.out.printf("Автор %s %s и его книги удалены из таблицы.\n",
                author.get().getFirstName(),
                author.get().getLastName());
    }


    @ShellMethod(value = "Get all books", key = {"get-all-books", "B"})
    public void getAllBooks() {
        bookService.findAllBooks().forEach(book ->
                System.out.printf("%s  '%s.'    Автор: %s %s    Жанр: %s\n",
                        book.getId(),
                        book.getBookName(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName(),
                        book.getGenre().getGenreName()));
    }

    @ShellMethod(value = "Get book by author", key = {"get-books-by-author", "BA"})
    public void getBookByAuthor(@ShellOption long authorId) {
        bookService.findByAuthorBook(authorId).forEach(book ->
                System.out.printf("%s  '%s.'    Автор: %s %s    Жанр: %s\n",
                        book.getId(),
                        book.getBookName(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName(),
                        book.getGenre().getGenreName()));
    }

    @ShellMethod(value = "Get book by genre", key = {"get-books-by-genre", "BG"})
    public void getBookByGenre(@ShellOption long genreId) {
        bookService.findByGenreBook(genreId).forEach(book ->
                System.out.printf("%s  '%s.'    Автор: %s %s    Жанр: %s\n",
                        book.getId(),
                        book.getBookName(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName(),
                        book.getGenre().getGenreName()));
    }

    @ShellMethod(value = "Get all genres", key = {"get-all-genre", "G"})
    public void getAllGenres() {
        genreService.findAllGenres().forEach(genre ->
                System.out.printf("%s  %s \n",
                        genre.getId(),
                        genre.getGenreName()));
    }

    @ShellMethod(value = "Get all comments", key = {"get-all-comments", "C"})
    public void getAllComments() {
        commentService.findAllComments().forEach(comment ->
                System.out.printf("%s  %s \n",
                        comment.getId(),
                        comment.getMessage()));
    }

    @ShellMethod(value = "Delete book", key = {"delete-book", "DB"})
    public void deleteBook(@ShellOption long id) {
        Book book = bookService.removeBook(id);
        System.out.printf("Книга удалена: %s, Автор %s\n",
                book.getBookName(),
                book.getAuthor().getLastName(),
                book.getAuthor().getFirstName());
    }

    @ShellMethod(value = "Delete genre", key = {"delete-genre", "DG"})
    public void deleteGenre(@ShellOption long id) {
        Genre genre = genreService.removeGenre(id);
        System.out.printf("Жанр %s и книги этого жанра удалены.\n",
                genre.getGenreName());
    }

    @ShellMethod(value = "Delete comment", key = {"delete-comment", "DC"})
    public void deleteComment(@ShellOption long id) {
        Comment comment = commentService.removeComment(id);
        System.out.printf("Комментарий %s' удален.\n",
                comment.getMessage());
    }

    @ShellMethod(value = "Create book", key = {"create-book", "CB"})
    public void createBook(@ShellOption long idGenre,
                           @ShellOption long idAuthor,
                           @ShellOption String bookName) {
        Book book = bookService.saveBook(idGenre, idAuthor, bookName);
        System.out.printf("Книга добавлена: %s, Автор %s\n",
                book.getBookName(),
                book.getAuthor().getLastName(),
                book.getAuthor().getFirstName());
    }

    @ShellMethod(value = "Create genre", key = {"create-genre", "CG"})
    public void createGenre(@ShellOption String codeGenre,
                             @ShellOption String genreName) {
        Genre genre = genreService.saveGenre(codeGenre, genreName);
        System.out.printf("Жанр %s %s добавлен\n",
                genre.getId(),
                genre.getGenreName());
    }

    @ShellMethod(value = "Create comment", key = {"create-comment", "CC"})
    public void createComment(@ShellOption String message,
                            @ShellOption long book_id) {
        Comment comment = commentService.saveComment(message, book_id);
        System.out.printf("Комментарий %s добавлен\n",
                comment.getMessage());
    }

    @ShellMethod(value = "Get book", key = {"get-book", "GB"})
    public void getBookById(@ShellOption long id) {
        Book book = bookService.findByIdBook(id);
        System.out.printf("%s  '%s.'    Автор: %s %s    Жанр: %s\n",
                book.getId(),
                book.getBookName(),
                book.getAuthor().getFirstName(),
                book.getAuthor().getLastName(),
                book.getGenre().getGenreName());
    }

    @ShellMethod(value = "Get genre by id", key = {"get-genre-id", "GGI"})
    public void getGenreNameById(@ShellOption long id) {
        Genre genre = genreService.findByIdGenre(id);
        System.out.printf("%s  %s \n",
                genre.getId(),
                genre.getGenreName());
    }

    @ShellMethod(value = "Get comment by id", key = {"get-comment-id", "GCI"})
    public void getCommentNameById(@ShellOption long id) {
        Comment comment = commentService.findByIdComment(id);
        System.out.printf("%s  %s \n",
                comment.getId(),
                comment.getMessage());
    }

}
