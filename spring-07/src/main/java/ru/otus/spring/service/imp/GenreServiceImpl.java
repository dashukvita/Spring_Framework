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
    @Transactional
    public Genre createGenre(String codeGenre, String genreName) {
        Genre genre = new Genre()
                .setCodeGenre(codeGenre)
                .setGenreName(genreName);
        genreRepository.save(genre);
        return genre;
    }

    @Override
    @Transactional
    public Genre deleteGenre(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new GenreNotFoundException("Genre with id " + id + " not found."));
        genreRepository.delete(genre);
        return genre;
    }

    @Override
    public Optional<Genre> findById(Long id) {
        return genreRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}
