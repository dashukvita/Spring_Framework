package ru.otus.spring.services.imp;

import ru.otus.spring.domain.Book;

import java.util.List;

public interface BookService {

    Book saveBook(long genre_id, long author_id, String bookname) throws Exception;

    Book removeBook(long id) throws Exception;

    Book findBookById(long id) throws Exception;

    List<Book> findByGenreBook(long genreId) throws Exception;

    List<Book> findByAuthorBook(long authorId) throws Exception;

    List<Book> findAllBooks();
}
