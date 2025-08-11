package ru.otus.spring.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import ru.otus.spring.dao.impl.BookDao;
import ru.otus.spring.entity.Author;
import ru.otus.spring.entity.Book;
import ru.otus.spring.entity.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations jdbc;

    @Override
    public Book create(Book book) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValues(Map.of(
                "author_id", book.getAuthor().getId(),
                "genre_id", book.getGenre().getId(),
                "bookname", book.getBookName()));

        jdbc.update( "insert into books (author_id, genre_id, bookname) " +
                "values (:author_id, :genre_id, :bookname)", params, keyHolder, new String[] { "id" });

        return (keyHolder.getKey() != null) ? getById(keyHolder.getKey().longValue()).get() : null;
    }

    @Override
    public void deleteById(long id) {
        jdbc.update("delete from books where id = :id", Map.of("id", id));
    }

    @Override
    public Optional<Book> getById(long id) {
        return jdbc.query("select * from books b " +
                        "inner join authors a on b.author_id = a.id " +
                        "inner join genres g on b.genre_id = g.id" +
                        " where b.id = :id",
                Map.of("id", id), new BookMapper()).stream().findFirst();
    }

    @Override
    public List<Book> getByGenre(long genreId) {
        return jdbc.query("select * from books b " +
                "inner join authors a on b.author_id = a.id " +
                "inner join genres g on b.genre_id = g.id" +
                " where g.id = :id", Map.of("id", genreId), new BookMapper());
    }

    @Override
    public List<Book> getByAuthor(long authorId) {
        return jdbc.query("select * from books b " +
                "inner join authors a on b.author_id = a.id " +
                "inner join genres g on b.genre_id = g.id" +
                " where a.id = :id", Map.of("id", authorId), new BookMapper());

    }

    @Override
    public List<Book> getAll() {
        return jdbc.query("select * from books b " +
                "inner join authors a on b.author_id = a.id " +
                "inner join genres g on b.genre_id = g.id",
                new BookMapper());
    }

    private static class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String bookname = resultSet.getString("bookname");

            long authorId = resultSet.getLong("author_id");
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            String birthday = resultSet.getString("birthday");

            long genreId = resultSet.getLong("genre_id");
            String codeGenre = resultSet.getString("codegenre");
            String genreName = resultSet.getString("genre");

            return Book.builder()
                    .id(id)
                    .bookName(bookname)
                    .author(Author.builder()
                            .id(authorId)
                            .firstName(firstName)
                            .lastName(lastName)
                            .birthday(birthday)
                            .build())
                    .genre(Genre.builder()
                            .id(genreId)
                            .codeGenre(codeGenre)
                            .genre(genreName)
                            .build())
                    .build();
        }
    }
}
