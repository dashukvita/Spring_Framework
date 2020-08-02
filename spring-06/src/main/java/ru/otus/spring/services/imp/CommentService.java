package ru.otus.spring.services.imp;

import ru.otus.spring.domain.Comment;

import java.util.List;

public interface CommentService {

    Comment saveComment(String message, long book_id);

    Comment removeComment(long id);

    Comment findByIdComment(long id);

    List<Comment> findAllComments();
}
