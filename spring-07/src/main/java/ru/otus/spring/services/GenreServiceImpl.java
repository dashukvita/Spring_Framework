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
    public Genre save(String code, String title){
        Genre genre = new Genre()
                .setCode(code)
                .setTitle(title);

        genreRepository.save(genre);
        return genre;
    }

    @Override
    public Genre remove(long id)  {
        Genre genre = genreRepository.findById(id)
            .orElseThrow(() -> new NullPointerException(String.format("Жанра с id '%s' нет в базе", id)));

        genreRepository.delete(genre);
        return genre;
    }

    @Override
    public Genre findById(long id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(String.format("Жанра с id '%s' нет в базе", id)));
    }

    @Override
    public Genre findByTitle(String title) throws Exception {
        Genre genre = genreRepository.findByTitle(title);

        if(genre == null){
            throw new Exception(String.format("Жанр '%s' не найден", title));
        } else{
            return genre;
        }
    }

    @Override
    public List<Genre> findAllGenres(){
        return genreRepository.findAll();
    }
}
