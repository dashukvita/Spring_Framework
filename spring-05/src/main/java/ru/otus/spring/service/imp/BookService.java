package ru.otus.spring.service.imp;

import ru.otus.spring.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book createBook(long authorId, long genreId, String bookname);

    Optional<Book> deleteBook(long id);

    Optional<Book> getByIdBook(long id);

    List<Book> getByGenreBook(long genreId);

    List<Book> getByAuthorBook(long authorId);

    List<Book> getAllBooks();
}
