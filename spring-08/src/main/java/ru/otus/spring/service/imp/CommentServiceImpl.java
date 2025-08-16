package ru.otus.spring.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.entity.Book;
import ru.otus.spring.entity.Comment;
import ru.otus.spring.exception.BookNotFoundException;
import ru.otus.spring.exception.CommentNotFoundException;
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
    @Transactional
    public Comment createComment(String message, Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book with id " + bookId + " not found."));

        Comment comment = new Comment()
                .setMessage(message)
                .setBook(book);

        commentRepository.save(comment);
        return comment;
    }

    @Override
    @Transactional
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("Comment with id " + id + " not found."));
        commentRepository.delete(comment);
    }

    @Override
    public List<Comment> findByBookId(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Comments for book with id " + bookId + " not found."));
        return commentRepository.findByBook(book);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
}
