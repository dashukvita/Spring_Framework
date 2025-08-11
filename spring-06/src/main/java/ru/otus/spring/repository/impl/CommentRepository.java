package ru.otus.spring.repository.impl;

import ru.otus.spring.entity.Comment;

import java.util.List;

public interface CommentRepository {

    Comment save(Comment comment);

    void remove(Comment comment);

    Comment findById(long id);

    List<Comment> findAll();
}
