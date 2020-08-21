package ru.otus.spring.services;

import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.repositories.impl.AuthorRepository;
import ru.otus.spring.repositories.impl.BookRepository;
import ru.otus.spring.repositories.impl.CommentRepository;
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
    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public Book saveBook(long genreId, long authorId, String bookname) throws Exception {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new NullPointerException(String.format("Автор с id '%s' не найден", authorId)));

        Genre genre = genreRepository.findById(genreId)
                .orElseThrow(() -> new NullPointerException(String.format("Жанра с id '%s' нет в базе", genreId)));

        Book book = new Book()
                .setGenre(genre)
                .setAuthor(author)
                .setBookName(bookname);

        bookRepository.save(book);
        return null;
    }

    @Override
    public Book removeBook(long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(String.format("Книга с id '%s' не найдена", id)));

        commentRepository.findAllByBookContains(book)
                .forEach(commentRepository::delete);
        bookRepository.delete(book);
        return book;
    }

    @Override
    @Transactional
    public Book findBookById(long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(String.format("Книга с id '%s' не найдена", id)));
    }

    @Override
    public List<Book> findByGenreBook(long genreId) throws Exception {
        Genre genre = genreRepository.findById(genreId)
                .orElseThrow(() -> new NullPointerException(String.format("Жанра с id '%s' нет в базе", genreId)));

        return bookRepository.findAllByGenreContains(genre);
    }

    @Override
    public List<Book> findByAuthorBook(long authorId) throws Exception {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new NullPointerException(String.format("Книги с id автора '%s' не найдены", authorId)));

        return bookRepository.findAllByAuthorContains(author);
    }

    @Override
    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

}
