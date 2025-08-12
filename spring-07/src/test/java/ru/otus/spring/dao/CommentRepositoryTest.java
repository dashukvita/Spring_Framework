package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.otus.spring.entity.Comment;
import ru.otus.spring.exception.AuthorNotFoundException;
import ru.otus.spring.exception.BookNotFoundException;
import ru.otus.spring.exception.CommentNotFoundException;
import ru.otus.spring.repository.BookRepository;
import ru.otus.spring.repository.CommentRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@DisplayName("CommentRepository")
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    @DisplayName("fetching comments by id fron db is correct")
    void getById() {
        Long id = 1L;
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("Comment with id " + id + " not found."));

        assertThat(comment).isNotNull();
        assertThat(comment.getMessage()).isEqualTo("Comments1");
        assertThat(comment.getBook().getId()).isEqualTo(1);
    }

    @Test
    @DisplayName("all comments are fetching from db")
    void findAll() {
        List<Comment> comments = commentRepository.findAll();

        assertThat(comments).isNotNull();
        assertThat(comments).hasSize(2);
    }

    @Test
    @DisplayName("adding comments from db is correct")
    void create() {
        String message = "Comments3";
        long bookId = 1;
        Comment comment = new Comment();
        comment.setMessage(message);
        comment.setBook(bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book with id " + bookId + " not found.")));

        commentRepository.save(comment);
        List<Comment> comments = commentRepository.findAll();

        assertThat(comments).hasSize(3);
        assertThat(comments).anySatisfy(c -> {
            assertThat(c.getMessage()).isEqualTo(message);
            assertThat(c.getBook().getId()).isEqualTo(bookId);
        });
    }

    @Test
    @DisplayName("deleting comment from db is correct")
    void delete() {
        Long id = 2L;
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("Comment with id " + id + " not found."));
        commentRepository.delete(comment);
        List<Comment> comments  = commentRepository.findAll();

        assertThat(comments).hasSize(1);
    }
}
