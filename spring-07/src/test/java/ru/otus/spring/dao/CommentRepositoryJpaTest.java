package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.otus.spring.entity.Comment;
import ru.otus.spring.repository.BookRepositoryJpa;
import ru.otus.spring.repository.CommentRepositoryJpa;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@Import({BookRepositoryJpa.class, CommentRepositoryJpa.class})
@AutoConfigureTestDatabase(replace = NONE)
@DisplayName("Класс CommentRepositoryJpa")
public class CommentRepositoryJpaTest {

    @Autowired
    private CommentRepositoryJpa commentRepositoryJpa;

    @Autowired
    private BookRepositoryJpa bookRepositoryJpa;

    @Test
    @DisplayName("получение комментария по id из бд корректно")
    void getById() {
        int id = 1;
        Comment comment = commentRepositoryJpa.findById(id);

        assertThat(comment).isNotNull();
        assertThat(comment.getMessage()).isEqualTo("Comments1");
        assertThat(comment.getBook().getId()).isEqualTo(1);
    }

    @Test
    @DisplayName("все комментарии из бд получены")
    void findAll() {
        List<Comment> comments = commentRepositoryJpa.findAll();

        assertThat(comments).isNotNull();
        assertEquals(comments.size(), 2);
    }

    @Test
    @DisplayName("добавление комментария в бд корректно")
    void create() {
        String message = "Comments3";
        long bookId = 1;
        Comment comment = new Comment();
        comment.setMessage(message);
        comment.setBook(bookRepositoryJpa.findById(bookId));

        commentRepositoryJpa.save(comment);
        List<Comment> comments = commentRepositoryJpa.findAll();


        assertThat(comments.get(2)).isEqualToIgnoringGivenFields(comment, "id");
    }

    @Test
    @DisplayName("удаление комментария из бд корректно")
    void delete() {
        int id = 2;
        Comment comment = commentRepositoryJpa.findById(id);
        commentRepositoryJpa.remove(comment);
        List<Comment> comments  = commentRepositoryJpa.findAll();

        assertEquals(comments.size(), 1);
    }
}
