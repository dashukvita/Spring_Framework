package ru.otus.spring.dao;

import ru.otus.spring.dao.impl.BookDao;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookDaoJdbc implements BookDao {

    private final JdbcOperations jdbc;

    @Override
    public void create(Book book) {
        jdbc.update("insert into book (id, author_id, genre_id, bookname) values (?, ?, ?, ?)",
                book.getId(),
                book.getAuthor().getId(),
                book.getGenre().getId(),
                book.getBookName());
    }

    @Override
    public void deleteById(long id) {
        jdbc.update("delete from book where id = ?", id);
    }

    @Override
    public Book getById(long id) {
        return jdbc.queryForObject("select * from book b " +
                "inner join author a on b.author_id = a.author_id " +
                "inner join genre g on b.genre_id = g.genre_id" +
                " where b.id = ?", new BookMapper(), id);
    }

    @Override
    public List<Book> getByGenre(long genreId) {
        return jdbc.query("select * from book b " +
                "inner join author a on b.author_id = a.author_id " +
                "inner join genre g on b.genre_id = g.genre_id" +
                " where g.genre_id = ?", new BookMapper(), genreId);
    }

    @Override
    public List<Book> getByAuthor(long authorId) {
        return jdbc.query("select * from book b " +
                "inner join author a on b.author_id = a.author_id " +
                "inner join genre g on b.genre_id = g.genre_id" +
                " where a.author_id = ?", new BookMapper(), authorId);
    }

    @Override
    public List<Book> getAll() {
        return jdbc.query("select * from book b " +
                "inner join author a on b.author_id = a.author_id " +
                "inner join genre g on b.genre_id = g.genre_id",
                new BookMapper());
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(*) from book", Integer.class);
    }

    private static class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String bookname = resultSet.getString("bookname");

            long author_id = resultSet.getLong("author_id");
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            String birthday = resultSet.getString("birthday");

            long genre_id = resultSet.getLong("genre_id");
            String codeGenre = resultSet.getString("codegenre");
            String genreName = resultSet.getString("genre");

            Author author = new Author(author_id, firstName, lastName, birthday);
            Genre genre = new Genre(genre_id, codeGenre, genreName);

            return new Book(id, author, genre, bookname);
        }
    }
}
