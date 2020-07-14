package ru.otus.spring.repositories;

import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.repositories.impl.GenreRepository;
import ru.otus.spring.domain.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
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
        Query query = em.createQuery("delete from Book b where b.genre.id = :genre_id");
        query.setParameter("genre_id", genre.getId());
        query.executeUpdate();

        em.remove(em.contains(genre) ? genre : em.merge(genre));
    }

    @Override
    public List<Genre> findAll() {
        return em.createQuery("select g from Genre g", Genre.class).getResultList();
    }

}
