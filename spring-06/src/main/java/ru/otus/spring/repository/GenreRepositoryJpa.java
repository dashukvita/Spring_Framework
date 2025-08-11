package ru.otus.spring.repository;

import ru.otus.spring.repository.impl.GenreRepository;
import ru.otus.spring.entity.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class GenreRepositoryJpa implements GenreRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Genre save(Genre genre) {
        if(genre.getId() == 0){
            em.persist(genre);
            return genre;
        } else {
            return em.merge(genre);
        }
    }

    @Override
    public Genre findById(long id) {
        return em.find(Genre.class, id);
    }

    @Override
    public void remove(Genre genre) {
        em.remove(genre);
    }

    @Override
    public List<Genre> findAll() {
        return em.createQuery("select g from Genre g", Genre.class).getResultList();
    }

}
