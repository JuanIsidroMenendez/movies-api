package dev.juanim.movies_api.genre;

import dev.juanim.movies_api.implementations.InterfaceGenericGetService;
import dev.juanim.movies_api.implementations.InterfaceGenericWriteService;

import org.springframework.stereotype.Service;

import java.util.List;
/* En esencia es idéntico a MovieServiceImpl */
@Service
public class GenreServiceImpl
        implements InterfaceGenericGetService<Genre>, InterfaceGenericWriteService<Genre> {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }
    @Override
    public List<Genre> getEntities() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre update(Long id, Genre genre) {
        genre.setId(id);
        return genreRepository.save(genre);
    }
    @Override
    public void delete(Long id) {
        genreRepository.deleteById(id);
    }
}