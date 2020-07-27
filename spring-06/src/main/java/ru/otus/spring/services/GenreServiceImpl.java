package ru.otus.spring.services;

import ru.otus.spring.dao.impl.GenreDao;
import ru.otus.spring.domain.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.services.imp.GenreService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreDao genreDao;

    @Override
    public Genre createGenre(long genre_id, String codegenre, String genreName){
        Genre genre = new Genre(genre_id, codegenre, genreName);
        genreDao.create(genre);
        return genre;
    }

    @Override
    public Genre deleteGenre(long id){
        Genre genre = genreDao.getById(id);
        genreDao.deleteById(id);
        return genre;
    }

    @Override
    public Genre getByIdGenre(long id){
        return genreDao.getById(id);
    }

    @Override
    public List<Genre> getAllGenres(){
        return genreDao.getAll();
    }
}
