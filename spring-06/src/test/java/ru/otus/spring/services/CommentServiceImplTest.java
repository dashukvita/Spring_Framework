package ru.otus.spring.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;
import ru.otus.spring.repositories.impl.BookRepository;
import ru.otus.spring.repositories.impl.CommentRepository;
import ru.otus.spring.services.imp.CommentService;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Класс CommentServiceImpl")
public class CommentServiceImplTest {

    private CommentRepository commentRepository;
    private BookRepository bookRepository;
    private CommentService commentService;

    @BeforeEach
    void setUp() {
        commentRepository = mock(CommentRepository.class);
        bookRepository = mock(BookRepository.class);
        commentService = new CommentServiceImpl(commentRepository, bookRepository);
    }

    @Test
    @DisplayName("получение комментария из бд корректно")
    void getAllComments() {
        int id= 1;
        String message = "message";
        Book book = new Book().setId(id);

        Comment comment = new Comment();
        comment.setMessage(message);
        comment.setBook(book);

        when(commentRepository.findAll()).thenReturn(Collections.singletonList(comment));

        List<Comment> resultComments = commentService.findAllComments();

        assertThat(resultComments).isNotNull();
        assertThat(resultComments).containsOnly(comment);
    }

    @Test
    @DisplayName("создание комментария корректно")
    void createComment() throws Exception {
        int id= 1;
        String message = "message";
        Book book = new Book().setId(id);

        when(bookRepository.findById(id)).thenReturn(book);

        Comment result = commentService.saveComment(message, id);

        assertThat(result).isNotNull();
        assertThat(result.getMessage()).isEqualTo(message);
    }

}
