package ru.otus.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.entity.Book;
import ru.otus.spring.entity.Comment;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
