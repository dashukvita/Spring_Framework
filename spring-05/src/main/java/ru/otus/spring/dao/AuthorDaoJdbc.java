package ru.otus.spring.dao;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import ru.otus.spring.dao.impl.AuthorDao;
import ru.otus.spring.domain.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Map.of;

@Repository
@RequiredArgsConstructor
public class AuthorDaoJdbc implements AuthorDao {

    private final NamedParameterJdbcOperations jdbc;

    @Override
    public Author create(Author author) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValues(Map.of(
                "firstname", author.getFirstName(),
                "lastname", author.getLastName(),
                "birthday", author.getBirthday()));

        jdbc.update("insert into authors (firstname, lastname, birthday) " +
                "values (:firstname, :lastname, :birthday)", params, keyHolder, new String[] { "id" });

        return (keyHolder.getKey() != null) ? getById(keyHolder.getKey().longValue()).get() : null;
    }

    @Override
    public void deleteById(long id) {
        jdbc.update("delete from books where books.author_id = :id", Map.of("id", id));
        jdbc.update("delete from authors where id = :id", Map.of("id", id));
    }

    @Override
    public Optional<Author> getById(long id) {
        return jdbc.query("select id, firstname, lastname, birthday from authors where id = :id",
                Map.of("id", id), new AuthorMapper())
                .stream().findFirst();
    }

    @Override
    public List<Author> getAll() {
        return jdbc.query("select id, firstname, lastname, birthday from authors", new AuthorMapper());
    }

    private static class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            long authorId = resultSet.getLong("id");
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            String birthday = resultSet.getString("birthday");

            return Author.builder()
                    .id(authorId)
                    .firstName(firstName)
                    .lastName(lastName)
                    .birthday(birthday)
                    .build();
        }
    }

}
