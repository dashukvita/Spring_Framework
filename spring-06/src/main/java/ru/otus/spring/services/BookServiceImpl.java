package ru.otus.spring.services;

import ru.otus.spring.repositories.impl.AuthorRepository;
import ru.otus.spring.repositories.impl.BookRepository;
import ru.otus.spring.repositories.impl.GenreRepository;
import ru.otus.spring.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.services.imp.BookService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    @Override
    public Book createBook(long id, long author_id, long genre_id, String bookname){
        Book book = new Book(id, authorRepository.getById(author_id), genreRepository.getById(genre_id), bookname);
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book deleteBook(long id){
        Book book = bookRepository.getById(id);
        bookRepository.deleteById(id);
        return book;
    }

    @Override
    public Book getByIdBook(long id){
        return bookRepository.getById(id);
    }

    @Override
    public List<Book> getByGenreBook(long genreId){
        return bookRepository.getByGenre(genreId);
    }

    @Override
    public List<Book> getByAuthorBook(long authorId){
        return bookRepository.getByAuthor(authorId);
    }

    @Override
    public List<Book> getAllBooks(){
        return bookRepository.getAll();
    }

}
