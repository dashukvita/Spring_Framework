package ru.otus.spring.service.imp;

import ru.otus.spring.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment saveComment(String message, long book_id) throws Exception;

    Comment removeComment(long id) throws Exception;

    List<Comment> findByBookId(long bookId) throws Exception;

    Comment findByIdComment(long id) throws Exception;

    List<Comment> findAllComments();
}
