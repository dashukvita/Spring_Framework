package ru.otus.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.entity.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
