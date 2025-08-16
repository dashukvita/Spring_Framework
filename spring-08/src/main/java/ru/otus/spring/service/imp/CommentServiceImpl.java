package ru.otus.spring.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.entity.Comment;
import ru.otus.spring.exception.BookNotFoundException;
import ru.otus.spring.exception.CommentNotFoundException;
import ru.otus.spring.repository.BookRepository;
import ru.otus.spring.repository.CommentRepository;
import ru.otus.spring.service.CommentService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    @Override
    public Comment createComment(String message, String bookId) {
        bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book with id " + bookId + " not found."));

        Comment comment = Comment.builder()
                .message(message)
                .bookId(bookId)
                .build();

        commentRepository.save(comment);
        return comment;
    }

    @Override
    public void deleteComment(String id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("Comment with id " + id + " not found."));
        commentRepository.delete(comment);
    }

    @Override
    public List<Comment> findByBookId(String bookId) {
        bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Comments for book with id " + bookId + " not found."));
//        return commentRepository.findByBook(bookId);
        return null;
    }

    @Override
    public Optional<Comment> findById(String id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
}
