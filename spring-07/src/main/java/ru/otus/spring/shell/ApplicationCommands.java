package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.entity.Author;
import ru.otus.spring.entity.Book;
import ru.otus.spring.entity.Comment;
import ru.otus.spring.entity.Genre;
import ru.otus.spring.exception.AuthorNotFoundException;
import ru.otus.spring.exception.BookNotFoundException;
import ru.otus.spring.exception.CommentNotFoundException;
import ru.otus.spring.exception.GenreNotFoundException;
import ru.otus.spring.service.AuthorService;
import ru.otus.spring.service.BookService;
import ru.otus.spring.service.CommentService;
import ru.otus.spring.service.GenreService;

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
    public void getAuthorById(@ShellOption Long id) {
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
    public void deleteAuthor(@ShellOption Long id) {
        Author author = authorService.findById(id).orElseThrow(() -> new AuthorNotFoundException("Author with id " + id + " not found."));

        authorService.deleteAuthor(id);
        System.out.printf("Автор %s %s и его книги удалены из таблицы.\n",
                author.getFirstName(),
                author.getLastName());
    }

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

    @ShellMethod(value = "Get genre by id", key = {"get-genre-id", "GG"})
    public void getGenreNameById(@ShellOption Long id) throws Exception {
        Genre genre = genreService.findById(id)
                .orElseThrow(() -> new Exception("Genre with id " + id + " not found."));

        System.out.printf("%s  %s \n",
                genre.getId(),
                genre.getGenreName());
    }

    @ShellMethod(value = "Delete genre", key = {"delete-genre", "DG"})
    public void deleteGenre(@ShellOption Long id) {
        Genre genre = genreService.findById(id)
                .orElseThrow(() -> new GenreNotFoundException("Genre with id " + id + " not found."));
        genreService.deleteGenre(id);
        System.out.printf("Жанр %s и книги этого жанра удалены.\n",
                genre.getGenreName());
    }

    @ShellMethod(value = "Get all comments", key = {"get-all-comments", "C"})
    public void getAllComments() {
        commentService.findAll().forEach(comment ->
                System.out.printf("'%s' - %s\n",
                        comment.getBook().getBookName(),
                        comment.getMessage()));
    }

    @ShellMethod(value = "Get comments by book", key = {"get-comments-by-book", "GCB"})
    public void getCommentsByBook(@ShellOption Long bookId) {
        commentService.findByBookId(bookId).forEach(comment ->
                System.out.printf("'%s' - %s\n",
                        comment.getBook().getBookName(),
                        comment.getMessage()));
    }

    @ShellMethod(value = "Create comment", key = {"create-comment", "CC"})
    public void createComment(@ShellOption String message,
                              @ShellOption Long bookId) {
        Comment comment = commentService.createComment(message, bookId);
        System.out.printf("Комментарий %s на книгу '%s' добавлен.\n",
                comment.getMessage(),
                comment.getBook().getBookName());
    }

    @ShellMethod(value = "Get comment by id", key = {"get-comment-id", "GC"})
    public void getCommentNameById(@ShellOption Long id) throws Exception {
        Comment comment = commentService.findById(id).orElseThrow(() -> new CommentNotFoundException("Comment with id " + id + " not found."));

        System.out.printf("%s  %s \n",
                comment.getId(),
                comment.getMessage());
    }

    @ShellMethod(value = "Delete comment", key = {"delete-comment", "DC"})
    public void deleteComment(@ShellOption Long id) {
        commentService.deleteComment(id);
    }

    @ShellMethod(value = "Get all books", key = {"get-all-books", "B"})
    public void getAllBooks() {
        bookService.findAll().forEach(book ->
                System.out.printf("%s  '%s.'    Автор: %s %s    Жанр: %s\n",
                        book.getId(),
                        book.getBookName(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName(),
                        book.getGenre().getGenreName()));
    }

    @ShellMethod(value = "Get book by author", key = {"get-books-by-author", "BA"})
    public void getBookByAuthor(@ShellOption Long authorId) {
        bookService.findByAuthor(authorId).forEach(book ->
                System.out.printf("%s  '%s.'    Автор: %s %s    Жанр: %s\n",
                        book.getId(),
                        book.getBookName(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName(),
                        book.getGenre().getGenreName()));
    }

    @ShellMethod(value = "Get book by genre", key = {"get-books-by-genre", "BG"})
    public void getBookByGenre(@ShellOption Long genreId) {
        bookService.findByGenre(genreId).forEach(book ->
                System.out.printf("%s  '%s.'    Автор: %s %s    Жанр: %s\n",
                        book.getId(),
                        book.getBookName(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName(),
                        book.getGenre().getGenreName()));
    }

    //    there
    @ShellMethod(value = "Delete book", key = {"delete-book", "DB"})
    public void deleteBook(@ShellOption Long id) {
        bookService.deleteBook(id);
    }

    @ShellMethod(value = "Create book", key = {"create-book", "CB"})
    public void createBook(@ShellOption Long idGenre,
                           @ShellOption Long idAuthor,
                           @ShellOption String bookName) {
        Book book = bookService.createBook(idGenre, idAuthor, bookName);
        System.out.printf("Книга добавлена: %s, Автор %s %s\n",
                book.getBookName(),
                book.getAuthor().getFirstName(),
                book.getAuthor().getLastName());
    }

    @ShellMethod(value = "Get book", key = {"get-book", "GB"})
    public void getBookById(@ShellOption Long id) {
        Book book = bookService.findById(id).orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found."));

        System.out.printf("%s  '%s'    Автор: %s %s    Жанр: %s\n",
                book.getId(),
                book.getBookName(),
                book.getAuthor().getFirstName(),
                book.getAuthor().getLastName(),
                book.getGenre().getGenreName());
    }

}
