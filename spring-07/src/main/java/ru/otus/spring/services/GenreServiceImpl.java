package ru.otus.spring.services;

import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.domain.Author;
import ru.otus.spring.repositories.impl.GenreRepository;
import ru.otus.spring.domain.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.services.imp.GenreService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    @Transactional
    public Genre saveGenre(String codeGenre, String genreName){
        Genre genre = new Genre()
                .setCodeGenre(codeGenre)
                .setGenreName(genreName);

        genreRepository.save(genre);
        return genre;
    }

    @Override
    public Genre removeGenre(long id)  {
        Genre genre = genreRepository.findById(id)
            .orElseThrow(() -> new NullPointerException(String.format("Жанра с id '%s' нет в базе", id)));

        genreRepository.delete(genre);
        return genre;
    }

    @Override
    public Genre findByIdGenre(long id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(String.format("Жанра с id '%s' нет в базе", id)));
    }

    @Override
    public List<Genre> findAllGenres(){
        return genreRepository.findAll();
    }
}
