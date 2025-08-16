package ru.otus.spring.service;

import ru.otus.spring.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Comment createComment(String message, String bookId);
    void deleteComment(String id);
    List<Comment> findByBookId(String bookId);
    Optional<Comment> findById(String id);
    List<Comment> findAll();
}
