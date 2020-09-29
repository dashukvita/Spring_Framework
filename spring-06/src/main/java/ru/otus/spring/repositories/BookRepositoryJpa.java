package ru.otus.spring.repositories;

import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.repositories.impl.BookRepository;
import ru.otus.spring.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;


@RequiredArgsConstructor
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
        em.remove(book);;
    }

    @Override
    public Book findById(long id) {
        return em.find(Book.class, id);
    }

    @Override
    public Book findByGenre(Genre genre) {
        return em.find(Book.class, genre.getId());
    }

    @Override
    public Book findByAuthor(Author author) {
        return em.find(Book.class, author.getId());
    }

    @Override
    public List<Book> findAll() {
        return em.createQuery("select b from Book b", Book.class).getResultList();
    }
}
