package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.entity.Author;
import ru.otus.spring.entity.Book;
import ru.otus.spring.entity.Comment;
import ru.otus.spring.entity.Genre;
import ru.otus.spring.service.imp.AuthorService;
import ru.otus.spring.service.imp.BookService;
import ru.otus.spring.service.imp.CommentService;
import ru.otus.spring.service.imp.GenreService;

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

    @ShellMethod(value = "Get author by id", key = {"get-author-id", "GA"})
    public void getAuthorById(@ShellOption long id) throws Exception {
        Optional<Author> author = Optional.ofNullable(authorService.findByIdAuthor(id));
        System.out.printf("%s  %s %s дата рождения %s\n",
                author.get().getId(),
                author.get().getFirstName(),
                author.get().getLastName(),
                author.get().getBirthday());
    }

    @ShellMethod(value = "Delete author", key = {"delete-author", "DA"})
    public void deleteAuthor(@ShellOption long id) throws Exception {
        Optional<Author> author = Optional.ofNullable(authorService.removeAuthor(id));
        System.out.printf("Автор %s %s и его книги удалены из таблицы.\n",
                author.get().getFirstName(),
                author.get().getLastName());
    }

    @ShellMethod(value = "Get all genres", key = {"get-all-genre", "G"})
    public void getAllGenres() {
        genreService.findAllGenres().forEach(genre ->
                System.out.printf("%s  %s \n",
                        genre.getId(),
                        genre.getGenreName()));
    }

    @ShellMethod(value = "Create genre", key = {"create-genre", "CG"})
    public void createGenre(@ShellOption String codeGenre,
                            @ShellOption String genreName) {
        Genre genre = genreService.saveGenre(codeGenre, genreName);
        System.out.printf("Жанр %s %s добавлен\n",
                genre.getId(),
                genre.getGenreName());
    }

    @ShellMethod(value = "Get genre by id", key = {"get-genre-id", "GG"})
    public void getGenreNameById(@ShellOption long id) throws Exception {
        Genre genre = genreService.findByIdGenre(id);
        System.out.printf("%s  %s \n",
                genre.getId(),
                genre.getGenreName());
    }

    @ShellMethod(value = "Delete genre", key = {"delete-genre", "DG"})
    public void deleteGenre(@ShellOption long id) throws Exception {
        Genre genre = genreService.removeGenre(id);
        System.out.printf("Жанр %s и книги этого жанра удалены.\n",
                genre.getGenreName());
    }

    @ShellMethod(value = "Get all comments", key = {"get-all-comments", "C"})
    public void getAllComments() {
        commentService.findAllComments().forEach(comment ->
                System.out.printf("'%s' - %s\n",
                        comment.getBook().getBookName(),
                        comment.getMessage()));
    }

    @ShellMethod(value = "Get comments by book", key = {"get-comments-by-book", "GCB"})
    public void getCommentsByBook(@ShellOption long book_id) throws Exception {
        commentService.findByBookId(book_id).forEach(comment ->
                System.out.printf("'%s' - %s\n",
                        comment.getBook().getBookName(),
                        comment.getMessage()));
    }

    @ShellMethod(value = "Create comment", key = {"create-comment", "CC"})
    public void createComment(@ShellOption String message,
                              @ShellOption long book_id) throws Exception {
        Comment comment = commentService.saveComment(message, book_id);
        System.out.printf("Комментарий %s на книгу '%s' добавлен.\n",
                comment.getMessage(),
                comment.getBook().getBookName());
    }

    @ShellMethod(value = "Get comment by id", key = {"get-comment-id", "GC"})
    public void getCommentNameById(@ShellOption long id) throws Exception {
        Comment comment = commentService.findByIdComment(id);
        System.out.printf("%s  %s \n",
                comment.getId(),
                comment.getMessage());
    }

    @ShellMethod(value = "Delete comment", key = {"delete-comment", "DC"})
    public void deleteComment(@ShellOption long id) throws Exception {
        Comment comment = commentService.removeComment(id);
        System.out.printf("Комментарий %s' удален.\n",
                comment.getMessage());
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
    public void getBookByAuthor(@ShellOption long authorId) throws Exception {
        bookService.findByAuthorBook(authorId).forEach(book ->
                System.out.printf("%s  '%s.'    Автор: %s %s    Жанр: %s\n",
                        book.getId(),
                        book.getBookName(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName(),
                        book.getGenre().getGenreName()));
    }

    @ShellMethod(value = "Get book by genre", key = {"get-books-by-genre", "BG"})
    public void getBookByGenre(@ShellOption long genreId) throws Exception {
        bookService.findByGenreBook(genreId).forEach(book ->
                System.out.printf("%s  '%s.'    Автор: %s %s    Жанр: %s\n",
                        book.getId(),
                        book.getBookName(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName(),
                        book.getGenre().getGenreName()));
    }

    //    there
    @ShellMethod(value = "Delete book", key = {"delete-book", "DB"})
    public void deleteBook(@ShellOption long id) throws Exception {
        Book book = bookService.removeBook(id);
        System.out.printf("Книга %s, Автор %s и все комментарии к ней удалены.\n",
                book.getBookName(),
                book.getAuthor().getLastName(),
                book.getAuthor().getFirstName());
    }

    @ShellMethod(value = "Create book", key = {"create-book", "CB"})
    public void createBook(@ShellOption long idGenre,
                           @ShellOption long idAuthor,
                           @ShellOption String bookName) throws Exception {
        Book book = bookService.saveBook(idGenre, idAuthor, bookName);
        System.out.printf("Книга добавлена: %s, Автор %s\n",
                book.getBookName(),
                book.getAuthor().getLastName(),
                book.getAuthor().getFirstName());
    }

    @ShellMethod(value = "Get book", key = {"get-book", "GB"})
    public void getBookById(@ShellOption long id) throws Exception {
        Book book = bookService.findByIdBook(id);
        System.out.printf("%s  '%s.'    Автор: %s %s    Жанр: %s\n",
                book.getId(),
                book.getBookName(),
                book.getAuthor().getFirstName(),
                book.getAuthor().getLastName(),
                book.getGenre().getGenreName());
    }

}
