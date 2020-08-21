package ru.otus.spring.repositories.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.domain.Genre;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
