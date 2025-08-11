package ru.otus.spring.service;

import ru.otus.spring.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(String message, Long bookId) throws Exception;
    Comment deleteComment(Long id) throws Exception;
    List<Comment> findByBookId(Long bookId) throws Exception;
    Comment findById(Long id) throws Exception;
    List<Comment> findAll();
}
