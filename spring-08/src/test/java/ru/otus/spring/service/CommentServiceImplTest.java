package ru.otus.spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.entity.Book;
import ru.otus.spring.entity.Comment;
import ru.otus.spring.repository.BookRepository;
import ru.otus.spring.repository.CommentRepository;
import ru.otus.spring.service.imp.CommentServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@DisplayName("CommentServiceImpl")
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

//    @Test
//    @DisplayName("fetching comment from db is correct")
//    void getAllComments() {
//        Long id= 1L;
//        String message = "message";
//        Book book = new Book().setId(id);
//
//        Comment comment = new Comment();
//        comment.setMessage(message);
//        comment.setBook(book);
//
//        when(commentRepository.findAll()).thenReturn(Collections.singletonList(comment));
//
//        List<Comment> resultComments = commentService.findAll();
//
//        assertThat(resultComments).isNotNull();
//        assertThat(resultComments).containsOnly(comment);
//    }
//
//    @Test
//    @DisplayName("creating comment is correct")
//    void createComment() throws Exception {
//        Long id= 1L;
//        String message = "message";
//        Book book = new Book().setId(id);
//
//        when(bookRepository.findById(id)).thenReturn(Optional.of(book));
//
//        Comment result = commentService.createComment(message, id);
//
//        assertThat(result).isNotNull();
//        assertThat(result.getMessage()).isEqualTo(message);
//        assertThat(result.getBook()).isEqualTo(book);
//
//        verify(bookRepository).findById(id);
//        verify(commentRepository).save(any(Comment.class));
//        verifyNoMoreInteractions(bookRepository, commentRepository);
//    }
}
