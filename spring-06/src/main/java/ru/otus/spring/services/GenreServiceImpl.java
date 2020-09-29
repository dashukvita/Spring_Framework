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
        Genre genre = new Genre()
                .setCodeGenre(codegenre)
                .setGenreName(genreName);

        genreRepository.save(genre);
        return genre;
    }

    @Override
    public Genre removeGenre(long id)  throws Exception {
        Genre genre = genreRepository.findById(id);

        if(genre == null){
            throw new Exception(String.format("Жанра с id '%s' нет в базе", id));
        } else {
            genreRepository.remove(genre);
            return genre;
        }
    }

    @Override
    public Genre findByIdGenre(long id) throws Exception {
        Genre genre = genreRepository.findById(id);

        if(genre == null){
            throw new Exception(String.format("Жанр с id '%s' не найден", id));
        } else {
            return genre;
        }
    }

    @Override
    public List<Genre> findAllGenres(){
        return genreRepository.findAll();
    }
}
