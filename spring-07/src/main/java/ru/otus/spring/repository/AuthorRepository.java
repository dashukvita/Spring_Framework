package ru.otus.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
