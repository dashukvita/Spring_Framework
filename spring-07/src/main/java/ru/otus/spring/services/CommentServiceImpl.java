package ru.otus.spring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;
import ru.otus.spring.repositories.impl.BookRepository;
import ru.otus.spring.repositories.impl.CommentRepository;
import ru.otus.spring.services.imp.CommentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public Comment save(String message, long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NullPointerException(String.format("Книги с id '%s' нет в базе", bookId)));

        Comment comment = new Comment()
                .setBook(book)
                .setMessage(message);

        commentRepository.save(comment);
        return comment;
    }

    @Override
    public Comment remove(long id) {
        Comment comment  = commentRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(String.format("Комментарий '%s' не найден", id)));

        commentRepository.delete(comment);
        return comment;
    }

    @Override
    public List<Comment> findByBookId(long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(String.format("Комментарии к книге с id '%s' не найдены", id)));

        return commentRepository.findAllByBook(book);
    }

    @Override
    public Comment findById(long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(String.format("Комментарий '%s' не найден", id)));
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
}
