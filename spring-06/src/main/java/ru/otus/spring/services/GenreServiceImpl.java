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
    public Genre saveGenre(String codegenre, String genreName){
        Genre genre = new Genre();
        genre.setCodeGenre(codegenre);
        genre.setGenreName(genreName);

        genreRepository.save(genre);
        return genre;
    }

    @Override
    public Genre removeGenre(long id){
        Genre genre = genreRepository.findById(id);
        genreRepository.remove(genre);
        return genre;
    }

    @Override
    public Genre findByIdGenre(long id){
        return genreRepository.findById(id);
    }

    @Override
    public List<Genre> findAllGenres(){
        return genreRepository.findAll();
    }
}
