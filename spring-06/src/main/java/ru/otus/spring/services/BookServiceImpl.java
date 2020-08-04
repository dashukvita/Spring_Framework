package ru.otus.spring.services;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    @Override
    @Transactional
    public Book saveBook(long genreId, long authorId, String bookname){
        Book book = new Book();
        book.setGenre(genreRepository.findById(genreId));
        book.setAuthor(authorRepository.findById(authorId));
        book.setBookName(bookname);

        bookRepository.save(book);
        return book;
    }

    @Override
    @Transactional
    public Book removeBook(long id){
        Book book = bookRepository.findById(id);
        if(book != null){
            bookRepository.remove(book);
        }
        return book;
    }

    @Override
    @Transactional
    public Book findByIdBook(long id){
        return bookRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Book> findByGenreBook(long genreId){
        Genre genre = genreRepository.findById(genreId);
        return bookRepository.findByGenre(genre);
    }

    @Override
    @Transactional
    public List<Book> findByAuthorBook(long authorId){
        Author author = authorRepository.findById(authorId);
        return bookRepository.findByAuthor(author);
    }

    @Override
    @Transactional
    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

}
