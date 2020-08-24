package ru.otus.spring.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CommentRepositoryTest {
    private static final long BOOK_ID = 1;

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    void findAllByBook() {

        Book book = new Book().setId(BOOK_ID);

        List<Comment> comments = commentRepository.findAllByBook(book);
        Comment resComment = entityManager.find(Comment.class, comments.get(0).getId());

        assertThat(comments).isNotNull();
        assertThat(resComment).isEqualTo(comments.get(0));
    }
}
