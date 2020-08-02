package ru.otus.spring.repositories.impl;

import ru.otus.spring.domain.Comment;

import java.util.List;

public interface CommentRepository {

    Comment save(Comment comment);

    void remove(Comment comment);

    Comment findById(long id);

    List<Comment> findAll();
}
