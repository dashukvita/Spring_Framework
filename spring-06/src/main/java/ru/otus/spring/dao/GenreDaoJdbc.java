package ru.otus.spring.dao;

import ru.otus.spring.dao.impl.GenreDao;
import ru.otus.spring.domain.Genre;
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
public class GenreDaoJdbc implements GenreDao {

    @PersistenceContext
    private EntityManager em;

    private final JdbcOperations jdbc;

    @Override
    public void create(Genre genre) {
        jdbc.update("insert into genre (genre_id, codegenre, genre) values (?, ?, ?)",
                genre.getId(),
                genre.getCodeGenre(),
                genre.getGenre());
    }

    @Override
    public void deleteById(long id) {
        jdbc.update("delete from book where genre_id = ?", id);
        jdbc.update("delete from genre where genre_id = ?", id);
    }

    @Override
    public Genre getById(long id) {
        return jdbc.queryForObject("select * from genre where genre_id = ?", new GenreMapper(), id);
    }

    @Override
    public List<Genre> getAll() {
        return jdbc.query("select * from genre", new GenreMapper());
    }

    private static class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            long genre_id = resultSet.getLong("genre_id");
            String codeGenre = resultSet.getString("codegenre");
            String genreName = resultSet.getString("genre");

            return new Genre(genre_id, codeGenre, genreName);
        }
    }
}
