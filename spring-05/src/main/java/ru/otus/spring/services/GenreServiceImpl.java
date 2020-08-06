package ru.otus.spring.services;

import ru.otus.spring.dao.impl.GenreDao;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.services.imp.GenreService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreDao genreDao;

    @Override
    public Genre createGenre(String codegenre, String genreName){
        Genre genre  = Genre.builder().codeGenre(codegenre).genre(genreName).build();
        genreDao.create(genre);
        
        return genre;
    }

    @Override
    public Optional<Genre> deleteGenre(long id){
        Optional<Genre> genre = genreDao.getById(id);
        genreDao.deleteById(id);
        return genre;
    }

    @Override
    public Optional<Genre> getByIdGenre(long id){
        return genreDao.getById(id);
    }

    @Override
    public List<Genre> getAllGenres(){
        return genreDao.getAll();
    }
}
