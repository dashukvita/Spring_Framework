package ru.otus.spring.services;

import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.repositories.impl.AuthorRepository;
import ru.otus.spring.repositories.impl.BookRepository;
import ru.otus.spring.repositories.impl.GenreRepository;
import ru.otus.spring.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.services.imp.BookService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    @Override
    public Book saveBook(long genreId, long authorId, String bookname){
        Author author = authorRepository.findById(authorId);
        Book book = new Book();
//        book.setAuthor(authorRepository.findById(authorId));
//        book.setGenre(genreRepository.findById(genreId));
//        book.setBookName(bookname);
//
//        bookRepository.save(book);
        return null;
    }

    @Override
    public Book removeBook(long id){
        Book book = bookRepository.findById(id);
        bookRepository.remove(Optional.ofNullable(book));
        return book;
    }

    @Override
    public Book findByIdBook(long id){
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findByGenreBook(long genreId){
        Genre genre = genreRepository.findById(genreId);
        return bookRepository.findByGenre(genre);
    }

    @Override
    public List<Book> findByAuthorBook(long authorId){
        Author author = authorRepository.findById(authorId);
        return bookRepository.findByAuthor(Optional.ofNullable(author));
    }

    @Override
    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

}
