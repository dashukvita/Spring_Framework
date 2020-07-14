package ru.otus.spring.services;

import ru.otus.spring.dao.impl.AuthorDao;
import ru.otus.spring.dao.impl.BookDao;
import ru.otus.spring.dao.impl.GenreDao;
import ru.otus.spring.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.services.imp.BookService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final AuthorDao authorDao;
    private final BookDao bookDao;
    private final GenreDao genreDao;

    @Override
    public Book createBook(long id, long author_id, long genre_id, String bookname){
        Book book = new Book(id, authorDao.getById(author_id), genreDao.getById(genre_id), bookname);
        bookDao.create(book);
        return book;
    }

    @Override
    public Book deleteBook(long id){
        Book book = bookDao.getById(id);
        bookDao.deleteById(id);
        return book;
    }

    @Override
    public Book getByIdBook(long id){
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getByGenreBook(long genreId){
        return bookDao.getByGenre(genreId);
    }

    @Override
    public List<Book> getByAuthorBook(long authorId){
        return bookDao.getByAuthor(authorId);
    }

    @Override
    public List<Book> getAllBooks(){
        return bookDao.getAll();
    }

}
