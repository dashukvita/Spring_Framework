package ru.otus.spring.repository;

import ru.otus.spring.repository.impl.AuthorRepository;
import ru.otus.spring.entity.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class AuthorRepositoryJpa implements AuthorRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Author save(Author author) {
        if(author.getId() == 0){
            em.persist(author);
            return author;
        } else {
            return em.merge(author);
        }
    }

    @Override
    public Author findById(long id) {
        return em.find(Author.class, id);
    }

    @Override
    public void remove(Author author) {
        em.remove(author);
    }

    @Override
    public List<Author> findAll() {
        return em.createQuery("select a from Author a", Author.class).getResultList();
    }

}
