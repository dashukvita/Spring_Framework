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

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public Comment saveComment(String message, long book_id) throws Exception {
        Book book = bookRepository.findById(book_id);

        if(book == null){
            throw new Exception(String.format("Книги с id '%s' нет в базе", book_id));
        } else {
            Comment comment = new Comment();
            comment.setMessage(message);
            comment.setBook(book);

            commentRepository.save(comment);
            return comment;
        }
    }

    @Override
    @Transactional
    public Comment removeComment(long id) throws Exception {
        Comment comment  = commentRepository.findById(id);

        if(comment == null){
            throw new Exception(String.format("Комментария с id '%s' нет в базе", id));
        } else {
            commentRepository.remove(comment);
            return comment;
        }
    }

    @Override
    public List<Comment> findByBookId(long bookId) throws Exception {
        Book book = bookRepository.findById(bookId);

        if(book.getId() == 0){
            throw new Exception(String.format("Комментарии к книги с id '%s' не найдены", bookId));
        } else {
            List<Comment> resultComments = new ArrayList<>();
            List<Comment> comments = commentRepository.findAll();
            for (Comment comment: comments) {
                if(comment.getBook().getId() == bookId){
                    resultComments.add(comment);
                }
            }
            return resultComments;
        }
    }

    @Override
    public Comment findByIdComment(long id) throws Exception {
        Comment comment  = commentRepository.findById(id);

        if(comment == null){
            throw new Exception(String.format("Комментарий с id '%s' не найден", id));
        } else {
            commentRepository.remove(comment);
            return comment;
        }
    }

    @Override
    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }
}
