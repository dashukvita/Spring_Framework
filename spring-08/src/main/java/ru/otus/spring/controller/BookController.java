package ru.otus.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.entity.Book;
import ru.otus.spring.exception.BookNotFoundException;


@ShellComponent
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

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
