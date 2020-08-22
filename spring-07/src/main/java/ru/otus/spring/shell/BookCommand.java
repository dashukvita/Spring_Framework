package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.domain.Book;
import ru.otus.spring.services.imp.BookService;

@ShellComponent
@RequiredArgsConstructor
public class BookCommand {

    private final BookService bookService;

    @ShellMethod(value = "Get book", key = {"get-book", "GB"})
    public void getBookById(@ShellOption long id) {
        Book book = bookService.findById(id);
        System.out.printf("%s  '%s.'    Автор: %s %s    Жанр: %s\n",
                book.getId(),
                book.getTitle(),
                book.getAuthor().getFirstName(),
                book.getAuthor().getLastName(),
                book.getGenre().getTitle());
    }

    @ShellMethod(value = "Get book by author", key = {"get-books-by-author", "BA"})
    public void getBookByAuthor(@ShellOption long authorId) {
        bookService.findByAuthor(authorId).forEach(book ->
                System.out.printf("%s  '%s.'    Автор: %s %s    Жанр: %s\n",
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName(),
                        book.getGenre().getTitle()));
    }

    @ShellMethod(value = "Get book by genre", key = {"get-books-by-genre", "BG"})
    public void getBookByGenre(@ShellOption long genreId) {
        bookService.findByGenre(genreId).forEach(book ->
                System.out.printf("%s  '%s.'    Автор: %s %s    Жанр: %s\n",
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName(),
                        book.getGenre().getTitle()));
    }

    @ShellMethod(value = "Get all books", key = {"get-all-books", "B"})
    public void getAllBooks() {
        bookService.findAll().forEach(book ->
                System.out.printf("%s  '%s.'    Автор: %s %s    Жанр: %s\n",
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName(),
                        book.getGenre().getTitle()));
    }

    @ShellMethod(value = "Create book", key = {"create-book", "CB"})
    public void createBook(@ShellOption long idGenre,
                           @ShellOption long idAuthor,
                           @ShellOption String bookName) {
        Book book = bookService.save(idGenre, idAuthor, bookName);
        System.out.printf("Книга добавлена: %s, Автор %s\n",
                book.getTitle(),
                book.getAuthor().getLastName(),
                book.getAuthor().getFirstName());
    }

    @ShellMethod(value = "Delete book", key = {"delete-book", "DB"})
    public void deleteBook(@ShellOption long id) {
        Book book = bookService.remove(id);
        System.out.printf("Книга %s, Автор %s и все комментарии к ней удалены.\n",
                book.getTitle(),
                book.getAuthor().getLastName(),
                book.getAuthor().getFirstName());
    }

}
