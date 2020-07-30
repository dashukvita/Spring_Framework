package ru.otus.spring.repositories;

import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.repositories.impl.BookRepository;
import ru.otus.spring.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@NamedEntityGraph(name = "author-entity-graph",
        attributeNodes = {@NamedAttributeNode("author")})
@RequiredArgsConstructor
@Transactional
@Repository
public class BookRepositoryJpa implements BookRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Book save(Book book) {
        if(book.getId() == 0){
            em.persist(book);
            return book;
        } else {
            return em.merge(book);
        }
    }

    @Override
    public void remove(Optional<Book> book) {
        em.remove(book);
    }

    @Override
    public Optional<Book> findById(long id) {
        return Optional.ofNullable(em.find(Book.class, id));
    }

    @Override
    public List<Book> findByGenre(Genre genre) {
        TypedQuery<Book> query = em.createQuery("select b from Book b " +
                "join fetch b.author " +
                "join fetch b.genre " +
                "where b.genre.id = :genre_id", Book.class);
        query.setParameter("genre_id", genre.getId());

        return query.getResultList();
    }

    @Override
    public List<Book> findByAuthor(Author author) {
        TypedQuery<Book> query = em.createQuery("select b from Book b " +
                "join fetch b.author " +
                "join fetch b.genre " +
                "where b.author.id = :author_id", Book.class);
        query.setParameter("author_id", author.getId());

        return query.getResultList();
    }

    @Override
    public List<Book> findAll() {
        EntityGraph<?> entityGraph = em.getEntityGraph("author-entity-graph");
        TypedQuery<Book> query = em.createQuery("select b from Book b join fetch b.genre", Book.class);
        query.setHint("javax.persistence.fetchgraph", entityGraph);

        return query.getResultList();
    }
}
