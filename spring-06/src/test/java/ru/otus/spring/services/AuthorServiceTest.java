package ru.otus.spring.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.repositories.impl.AuthorRepository;
import ru.otus.spring.domain.Author;
import ru.otus.spring.services.imp.AuthorService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;


@DisplayName("Класс AuthorService")
public class AuthorServiceTest {

//    private AuthorRepository authorRepository;
//    private AuthorService authorService;
//
//    @BeforeEach
//    void setUp() {
//        authorRepository = mock(AuthorRepository.class);
//        authorService = new AuthorServiceImpl(authorRepository);
//    }
//
//    @Test
//    @DisplayName("получение авторов из бд корректно")
//    void getAllAuthors() {
//        ArrayList<Author> authors = new ArrayList<>();
//        when(authorRepository.findAll()).thenReturn(authors);
//
//        List<Author> resultAuthors = authorService.findAllAuthors();
//
//        assertThat(resultAuthors).isNotNull();
//        assertThat(resultAuthors).isEqualTo(authors);
//        verify(authorRepository).findAll();
//        verifyNoMoreInteractions(authorRepository);
//    }
//
//    @Test
//    @DisplayName("создание автора корректно")
//    void createAuthor() {
//        long authorId = 3;
//        String firstName = "Author3";
//        String lastName = "Author3";
//        String birthday = "01.01.2020";
//
//        Author resultAuthor = authorService.saveAuthor(authorId, firstName, lastName, birthday);
//
//        assertThat(resultAuthor).isNotNull();
//        assertThat(resultAuthor.getFirstName()).isEqualTo(firstName);
//        assertThat(resultAuthor.getLastName()).isEqualTo(lastName);
//        assertThat(resultAuthor.getBirthday()).isEqualTo(birthday);
//        verify(authorRepository).save(any(Author.class));
//        verifyNoMoreInteractions(authorRepository);
//    }
}
