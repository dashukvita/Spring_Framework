package ru.otus.spring.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.entity.Author;
import ru.otus.spring.entity.Book;
import ru.otus.spring.entity.Genre;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @EntityGraph(value = "author-genre-graph", type = EntityGraph.EntityGraphType.FETCH)
    List<Book> findByGenre(Genre genre);
    @EntityGraph(value = "author-genre-graph", type = EntityGraph.EntityGraphType.FETCH)
    List<Book> findByAuthor(Author author);
}
