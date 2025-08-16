package ru.otus.spring.mongockchangelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import ru.otus.spring.entity.Author;
import ru.otus.spring.entity.Book;
import ru.otus.spring.entity.Comment;
import ru.otus.spring.entity.Genre;
import ru.otus.spring.repository.AuthorRepository;
import ru.otus.spring.repository.BookRepository;
import ru.otus.spring.repository.CommentRepository;
import ru.otus.spring.repository.GenreRepository;

@ChangeLog(order = "001")
public class DatabaseChangelog {

    @ChangeSet(order = "000", id= "dropDb", author = "admin", runAlways = true)
    public void dropDb(final MongoDatabase mongoDatabase) {
        mongoDatabase.drop();
    }

    @ChangeSet(order = "002", id= "dropDb", author = "admin", runAlways = true)
    public void initAuthors(final AuthorRepository authorsRepository) {
        authorsRepository.save(Author.builder()
                .firstName("Author1")
                .lastName("Author1")
                .birthday("1965-07-31")
                .build());
        authorsRepository.save(Author.builder()
                .firstName("Author2")
                .lastName("Author2")
                .birthday("1932-01-05")
                .build());
    }

    @ChangeSet(order = "003", id= "dropDb", author = "admin", runAlways = true)
    public void initGenres(final GenreRepository genreRepository) {
        genreRepository.save(Genre.builder()
                .codeGenre("CL")
                .genreName("Detective")
                .build());

        genreRepository.save(Genre.builder()
                .codeGenre("BP")
                .genreName("Novel")
                .build());
    }

    @ChangeSet(order = "004", id= "dropDb", author = "admin", runAlways = true)
    public void initBooks(final BookRepository bookRepository) {
        bookRepository.save(Book.builder()
                .authorId("1")
                .genreId("1")
                .bookName("Book1")
                .build());

        bookRepository.save(Book.builder()
                .authorId("2")
                .genreId("2")
                .bookName("Book2")
                .build());
    }

    @ChangeSet(order = "005", id= "dropDb", author = "admin", runAlways = true)
    public void initComments(final CommentRepository commentRepository) {
        commentRepository.save(Comment.builder()
                .bookId("1")
                .message("Comment1")
                .build());

        commentRepository.save(Comment.builder()
                .bookId("2")
                .message("Comment2")
                .build());
    }
}
