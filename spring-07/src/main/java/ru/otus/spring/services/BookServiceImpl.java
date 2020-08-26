package ru.otus.spring.services;

import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.repositories.AuthorRepository;
import ru.otus.spring.repositories.GenreRepository;
import ru.otus.spring.repositories.BookRepository;
import ru.otus.spring.repositories.CommentRepository;
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
    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public Book save(long genreId, long authorId, String title) {

        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new NullPointerException(String.format("Автор с id '%s' не найден", authorId)));

        Genre genre = genreRepository.findById(genreId)
                .orElseThrow(() -> new NullPointerException(String.format("Жанра с id '%s' нет в базе", genreId)));

        Book book = new Book()
                .setGenre(genre)
                .setAuthor(author)
                .setTitle(title);

        return bookRepository.save(book);
    }

    @Override
    public Book remove(long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(String.format("Книга с id '%s' не найдена", id)));

        bookRepository.delete(book);
        return book;
    }

    @Override
    @Transactional
    public Book findById(long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(String.format("Книга с id '%s' не найдена", id)));
    }

    @Override
    public List<Book> findByGenre(long genreId)  {
        Genre genre = genreRepository.findById(genreId)
                .orElseThrow(() -> new NullPointerException(String.format("Жанра с id '%s' нет в базе", genreId)));

        return genre.getBooks();
    }

    @Override
    public List<Book> findByAuthor(long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new NullPointerException(String.format("Книги с id автора '%s' не найдены", authorId)));

        return author.getBooks();
    }

    @Override
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

}
