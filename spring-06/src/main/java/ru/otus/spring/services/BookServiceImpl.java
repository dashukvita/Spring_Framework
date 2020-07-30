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
    public Book saveBook(long id, long authorId, long genreId, String bookname){
        Author author = authorRepository.findById(authorId);
        Genre genre = genreRepository.findById(genreId);
        Book book = new Book(id, author, genre, bookname);
        bookRepository.save(book);
        return book;
    }

    @Override
    public Optional<Book> removeBook(long id){
        Optional<Book> book = bookRepository.findById(id);
        bookRepository.remove(book);
        return book;
    }

    @Override
    public Optional<Book> findByIdBook(long id){
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
        return bookRepository.findByAuthor(author);
    }

    @Override
    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

}
