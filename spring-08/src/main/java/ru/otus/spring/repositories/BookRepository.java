package ru.otus.spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.entities.Book;


public interface BookRepository extends MongoRepository<Book, String> {
}
