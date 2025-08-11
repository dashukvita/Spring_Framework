package ru.otus.spring.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.spring.entity.Comment;
import ru.otus.spring.repository.impl.CommentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class CommentRepositoryJpa implements CommentRepository {

    @PersistenceContext
    private EntityManager em;
    private Class<Comment> comments;

    @Override
    public Comment save(Comment comment) {
        if(comment.getId() == 0){
            em.persist(comment);
            return comment;
        } else {
            return em.merge(comment);
        }
    }

    @Override
    public void remove(Comment comment) {
        em.remove(comment);;
    }

    @Override
    public Comment findById(long id) {
        return em.find(Comment.class, id);
    }

    @Override
    public List<Comment> findAll() {
        return em.createQuery("select c FROM Comment c", Comment.class).getResultList();
    }
}
