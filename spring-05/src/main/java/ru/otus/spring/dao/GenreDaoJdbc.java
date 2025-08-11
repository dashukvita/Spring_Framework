package ru.otus.spring.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import ru.otus.spring.dao.impl.GenreDao;
import ru.otus.spring.entity.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GenreDaoJdbc implements GenreDao {

    private final NamedParameterJdbcOperations jdbc;

    @Override
    public Genre create(Genre genre) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValues(Map.of(
                "codegenre", genre.getCodeGenre(),
                "genre", genre.getGenre()));

        jdbc.update("insert into genres (codegenre, genre) " +
                "values (:codegenre, :genre)", params, keyHolder, new String[] { "id" });

        return (keyHolder.getKey() != null) ? getById(keyHolder.getKey().longValue()).get() : null;
    }

    @Override
    public void deleteById(long id) {
        jdbc.update("delete from books where books.genre_id = :id", Map.of("id", id));
        jdbc.update("delete from genres where id = :id", Map.of("id", id));
    }

    @Override
    public Optional<Genre> getById(long id) {
        return jdbc.query("select id, codegenre, genre from genres where id = :id",
                Map.of("id", id), new GenreDaoJdbc.GenreMapper())
                .stream().findFirst();
    }

    @Override
    public List<Genre> getAll() {
        return jdbc.query("select id, codegenre, genre from genres", new GenreDaoJdbc.GenreMapper());
    }

    private static class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String codeGenre = resultSet.getString("codegenre");
            String genreName = resultSet.getString("genre");

            return Genre.builder()
                    .id(id)
                    .codeGenre(codeGenre)
                    .genre(genreName)
                    .build();
        }
    }
}
