package ru.otus.spring.services.imp;

import ru.otus.spring.domain.Book;

import java.util.List;

public interface BookService {

    Book createBook(long id, long author_id, long genre_id, String bookname);

    Book deleteBook(long id);

    Book getByIdBook(long id);

    List<Book> getByGenreBook(long genreId);

    List<Book> getByAuthorBook(long authorId);

    List<Book> getAllBooks();
}
