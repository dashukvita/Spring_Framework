package ru.otus.spring.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.spring.dao.impl.AuthorDao;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.services.imp.AuthorService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@DisplayName("Класс AuthorService")
public class AuthorServiceTest {

    private AuthorDao authorDao;
    private AuthorService authorService;

    @BeforeEach
    void setUp() {
        authorDao = mock(AuthorDao.class);
        authorService = new AuthorServiceImpl(authorDao);
    }

    @Test
    @DisplayName("получение авторов из бд корректно")
    void getAllAuthors() {
        ArrayList<Author> authors = new ArrayList<>();
        when(authorDao.getAll()).thenReturn(authors);

        List<Author> resultAuthors = authorService.getAllAuthors();

        assertThat(resultAuthors).isNotNull();
        assertThat(resultAuthors).isEqualTo(authors);
        verify(authorDao).getAll();
        verifyNoMoreInteractions(authorDao);
    }

    @Test
    @DisplayName("создание автора корректно")
    void createAuthor() {
        String firstName = "Author3";
        String lastName = "Author3";
        String birthday = "01.01.2020";

        Author resultAuthor = authorService.createAuthor(firstName, lastName, birthday);

        assertThat(resultAuthor).isNotNull();
        assertThat(resultAuthor.getFirstName()).isEqualTo(firstName);
        assertThat(resultAuthor.getLastName()).isEqualTo(lastName);
        assertThat(resultAuthor.getBirthday()).isEqualTo(birthday);
        verify(authorDao).create(any(Author.class));
        verifyNoMoreInteractions(authorDao);

    }
}
