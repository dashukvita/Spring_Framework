package ru.otus.spring.services.imp;

import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;

import java.util.List;

public interface CommentService {

    Comment save(String message, long bookId);

    Comment remove(long id);

    List<Comment> findByBookId(long bookId);

    Comment findById(long id);

    List<Comment> findAll();
}
