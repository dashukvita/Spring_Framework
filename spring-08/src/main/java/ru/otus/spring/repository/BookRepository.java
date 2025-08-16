package ru.otus.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.entity.Author;
import ru.otus.spring.entity.Book;
import ru.otus.spring.entity.Genre;

import java.util.List;


public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByGenre(Genre genre);

    List<Book> findByAuthor(Author author);
}
