package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.otus.spring.domain.Author;
import ru.otus.spring.repositories.AuthorRepositoryJpa;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@Import(AuthorRepositoryJpa.class)
@AutoConfigureTestDatabase(replace = NONE)
@DisplayName("Класс AuthorDaoJdbc")
class AuthorRepositoryJpaTest {

    @Autowired
    private AuthorRepositoryJpa authorRepositoryJpa;
//
//    @Test
//    @DisplayName("получение автора по id из бд корректно")
//    void getById() {
//        int id = 1;
//        Author author = authorRepositoryJpa.findById(id);
//
//        assertThat(author).isNotNull();
//        assertThat(author.getFirstName()).isEqualTo("Author1");
//        assertThat(author.getLastName()).isEqualTo("Author1");
//        assertThat(author.getBirthday()).isEqualTo("31.07.1965");
//    }
//
    @Test
    @DisplayName("все авторы из бд получены")
    void findAll() {
        List<Author> authors = authorRepositoryJpa.findAll();

        assertThat(authors).isNotNull();
        assertEquals(authors.size(), 2);
    }

//    @Test
//    @DisplayName("добавление автора в бд корректно")
//    void create() {
//        long authorId = 3;
//        String firstName = "Author3";
//        String lastName = "Author3";
//        String birthDay = "05.01.1932";
//        Author author = new Author(authorId, firstName, lastName, birthDay);
//        authorRepositoryJpa.save(author);
//        List<Author> authors = authorRepositoryJpa.findAll();
//
//
//        assertThat(authors.get(2)).isEqualToIgnoringGivenFields(author, "id");
//    }
//
//    @Test
//    @DisplayName("удаление автора из бд корректно")
//    void delete() {
//        int id = 3;
//        Author author= authorRepositoryJpa.findById(id);
//        authorRepositoryJpa.remove(author);
//        List<Author> authors = authorRepositoryJpa.findAll();
//
//        assertEquals(authors.size(), 2);
//    }
}
