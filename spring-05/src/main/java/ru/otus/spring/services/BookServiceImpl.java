package ru.otus.spring.services;

import ru.otus.spring.dao.impl.AuthorDao;
import ru.otus.spring.dao.impl.BookDao;
import ru.otus.spring.dao.impl.GenreDao;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.services.imp.BookService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final AuthorDao authorDao;
    private final BookDao bookDao;
    private final GenreDao genreDao;

    @Override
    public Book createBook(long authorId, long genreId, String bookname){
        Author author = authorDao.getById(authorId).get();
        Genre genre = genreDao.getById(genreId).get();

        Book book = Book.builder().author(author).genre(genre).bookName(bookname).build();
        bookDao.create(book);

        return book;
    }

    @Override
    public Optional<Book> deleteBook(long id){
        Optional<Book> book = bookDao.getById(id);
        bookDao.deleteById(id);
        return book;
    }

    @Override
    public Optional<Book> getByIdBook(long id){
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
