package ru.otus.spring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.domain.Author;
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
    public Comment saveComment(String message, long book_id) {
        Comment comment = new Comment();
        comment.setMessage(message);
        comment.setBook(bookRepository.findById(book_id));

        commentRepository.save(comment);
        return comment;
    }

    @Override
    @Transactional
    public Comment removeComment(long id) {
        Comment comment  = commentRepository.findById(id);
        commentRepository.remove(comment);
        return comment;
    }

    @Override
    @Transactional
    public Comment findByIdComment(long id) {
        return commentRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }
}
