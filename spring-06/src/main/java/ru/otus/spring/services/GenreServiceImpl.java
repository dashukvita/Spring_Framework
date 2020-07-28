package ru.otus.spring.services;

import ru.otus.spring.repositories.impl.GenreRepository;
import ru.otus.spring.domain.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.services.imp.GenreService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public Genre createGenre(long id, String codegenre, String genreName){
        Genre genre = new Genre(id, codegenre, genreName);
        genreRepository.save(genre);
        return genre;
    }

    @Override
    public Genre deleteGenre(long id){
        Genre genre = genreRepository.getById(id);
        genreRepository.deleteById(id);
        return genre;
    }

    @Override
    public Genre getByIdGenre(long id){
        return genreRepository.getById(id);
    }

    @Override
    public List<Genre> getAllGenres(){
        return genreRepository.getAll();
    }
}
