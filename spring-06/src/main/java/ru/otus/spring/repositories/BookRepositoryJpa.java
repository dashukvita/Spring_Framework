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
    public void remove(Book book) {
        Query query = em.createQuery("delete from Comment c where c.book.id = :book_id");
        query.setParameter("book_id", book.getId());
        query.executeUpdate();

        em.remove(em.contains(book) ? book : em.merge(book));
    }

    @Override
    public Book findById(long id) {
        return em.find(Book.class, id);
    }

    @Override
    public List<Book> findByGenre(Genre genre) {
        TypedQuery<Book> query = em.createQuery("select b from Book b " +
                "join fetch b.genre " +
                "join fetch b.author " +
                "where b.genre.id = :genre_id", Book.class);
        query.setParameter("genre_id", genre.getId());

        return query.getResultList();
    }

    @Override
    public List<Book> findByAuthor(Author author) {
        TypedQuery<Book> query = em.createQuery("select b from Book b " +
                "join fetch b.genre " +
                "join fetch b.author " +
                "where b.author.id = :author_id", Book.class);
        query.setParameter("author_id", author.getId());

        return query.getResultList();
    }

    @Override
    public List<Book> findAll() {
        EntityGraph<?> entityGraph = em.getEntityGraph("author-genre-graph");
        TypedQuery<Book> query = em.createQuery("select b from Book b", Book.class);
        query.setHint("javax.persistence.fetchgraph", entityGraph);

        return query.getResultList();
    }
}
