package ru.otus.spring.dao;

import ru.otus.spring.dao.impl.AuthorDao;
import ru.otus.spring.domain.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthorDaoJdbc implements AuthorDao {

    @PersistenceContext
    private EntityManager em;

    private final JdbcOperations jdbc;

    @Override
    public void create(Author author) {
        jdbc.update("insert into author (author_id, firstname, lastname, birthday) values (?, ?, ?, ?)",
                author.getId(),
                author.getFirstName(),
                author.getLastName(),
                author.getBirthday());
    }

    @Override
    public void deleteById(long id) {
        jdbc.update("delete from book where author_id = ?", id);
        jdbc.update("delete from author where author_id = ?", id);
    }

    @Override
    public Author getById(long id) {
        return jdbc.queryForObject("select * from author where author_id = ?", new AuthorMapper(), id);
    }

    @Override
    public List<Author> getAll() {
        return jdbc.query("select * from author", new AuthorMapper());
    }

    private static class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            long author_id = resultSet.getLong("author_id");
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            String birthday = resultSet.getString("birthday");

            return new Author(author_id, firstName, lastName, birthday);
        }
    }
}
