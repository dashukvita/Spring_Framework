package ru.otus.spring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;
import ru.otus.spring.repositories.impl.BookRepository;
import ru.otus.spring.repositories.impl.CommentRepository;
import ru.otus.spring.services.imp.CommentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public Comment saveComment(String message, long book_id) throws Exception {
        Book book = bookRepository.findById(book_id)
                .orElseThrow(() -> new NullPointerException(String.format("Книги с id '%s' нет в базе", book_id)));

        Comment comment = new Comment()
                .setBook(book)
                .setMessage(message);

        commentRepository.save(comment);
        return comment;
    }

    @Override
    public Comment removeComment(long id) {
        Comment comment  = commentRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(String.format("Комментарий '%s' не найден", id)));

        commentRepository.delete(comment);
        return comment;
    }

    @Override
    public List<Comment> findByBookId(long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(String.format("Комментарии к книге с id '%s' не найдены", id)));

        return commentRepository.findAllByBookContains(book);
    }

    @Override
    public Comment findByIdComment(long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(String.format("Комментарий '%s' не найден", id)));
    }

    @Override
    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }
}
