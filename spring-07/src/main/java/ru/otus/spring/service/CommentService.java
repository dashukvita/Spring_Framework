package ru.otus.spring.service;

import ru.otus.spring.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Comment createComment(String message, Long bookId);
    void deleteComment(Long id);
    List<Comment> findByBookId(Long bookId);
    Optional<Comment> findById(Long id);
    List<Comment> findAll();
}
