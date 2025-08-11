package ru.otus.spring.service.imp;

import ru.otus.spring.entity.Book;

import java.util.List;

public interface BookService {

    Book saveBook(long genre_id, long author_id, String bookname) throws Exception;

    Book removeBook(long id) throws Exception;

    Book findByIdBook(long id) throws Exception;

    List<Book> findByGenreBook(long genreId) throws Exception;

    List<Book> findByAuthorBook(long authorId) throws Exception;

    List<Book> findAllBooks();
}
