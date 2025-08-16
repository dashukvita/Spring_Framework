package ru.otus.spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import ru.otus.spring.entity.Author;
import ru.otus.spring.repository.AuthorRepository;
import ru.otus.spring.service.imp.AuthorServiceImpl;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;


@DisplayName("AuthorService")
public class AuthorServiceImplTest {

    private AuthorRepository authorRepository;
    private AuthorService authorService;

    @BeforeEach
    void setUp() {
        authorRepository = mock(AuthorRepository.class);
        authorService = new AuthorServiceImpl(authorRepository);
    }

    @Test
    @DisplayName("fetching authors from db is correct")
    void getAllAuthors() {
        List<Author> authors = List.of(
                new Author().setId(1L).setFirstName("Author1").setLastName("Last1").setBirthday("01.01.2000")
        );
        when(authorRepository.findAll()).thenReturn(authors);

        List<Author> resultAuthors = authorService.findAll();

        assertThat(resultAuthors).isNotNull().hasSize(1);
        assertThat(resultAuthors.get(0).getFirstName()).isEqualTo("Author1");
        verify(authorRepository).findAll();
        verifyNoMoreInteractions(authorRepository);
    }

    @Test
    @DisplayName("creating author is correct")
    void createAuthor() {
        String firstName = "Author3";
        String lastName = "Author3";
        String birthday = "01.01.2020";

        ArgumentCaptor<Author> captor = ArgumentCaptor.forClass(Author.class);

        authorService.createAuthor(firstName, lastName, birthday);

        verify(authorRepository).save(captor.capture());
        Author savedAuthor = captor.getValue();
        assertThat(savedAuthor.getFirstName()).isEqualTo(firstName);
        assertThat(savedAuthor.getLastName()).isEqualTo(lastName);
        assertThat(savedAuthor.getBirthday()).isEqualTo(birthday);

        verifyNoMoreInteractions(authorRepository);
    }
}
