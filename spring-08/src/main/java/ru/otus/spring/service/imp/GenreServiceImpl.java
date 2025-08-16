package ru.otus.spring.service.imp;

import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.entity.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.exception.GenreNotFoundException;
import ru.otus.spring.repository.GenreRepository;
import ru.otus.spring.service.GenreService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public Genre createGenre(String codeGenre, String genreName) {
        Genre genre = Genre.builder()
                .codeGenre(codeGenre)
                .genreName(genreName)
                .build();

        genreRepository.save(genre);
        return genre;
    }

    @Override
    public Genre deleteGenre(String id) {
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new GenreNotFoundException("Genre with id " + id + " not found."));
        genreRepository.delete(genre);
        return genre;
    }

    @Override
    public Optional<Genre> findById(String id) {
        return genreRepository.findById(id);
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}
