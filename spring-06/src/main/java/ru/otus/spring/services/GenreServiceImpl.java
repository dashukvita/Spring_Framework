package ru.otus.spring.services;

import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public Genre saveGenre(String codegenre, String genreName){
        Genre genre = new Genre();
        genre.setCodeGenre(codegenre);
        genre.setGenreName(genreName);

        genreRepository.save(genre);
        return genre;
    }

    @Override
    @Transactional
    public Genre removeGenre(long id){
        Genre genre = genreRepository.findById(id);
        if(genre != null){
            genreRepository.remove(genre);
        }
        return genre;
    }

    @Override
    @Transactional
    public Genre findByIdGenre(long id){
        return genreRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Genre> findAllGenres(){
        return genreRepository.findAll();
    }
}
