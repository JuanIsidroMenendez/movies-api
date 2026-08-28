package dev.juanim.movies_api.movie.mappers;

import dev.juanim.movies_api.movie.Movie;
import dev.juanim.movies_api.movie.dtos.MovieRequestDTO;
import dev.juanim.movies_api.movie.dtos.MovieResponseDTO;
import dev.juanim.movies_api.genre.Genre;
import dev.juanim.movies_api.genre.GenreRepository;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    private final GenreRepository genreRepository;

    public MovieMapper(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    /*DTO entrada, para guardar en BD */
    /* public static Movie toEntity(MovieRequestDTO dtoRequest) {
        Movie movie = new Movie();
        movie.setTitle(dtoRequest.title());
        return movie;
    } REFACTORIZACIÓN */
    public Movie toEntity(MovieRequestDTO dto) {
        Movie movie = new Movie();
        movie.setTitle(dto.title());

        if(dto.genreIds() !=null) {
            List<Genre> genres = genreRepository.findAllById(dto.genreIds());
            movie.setGenres(genres);
        }
        return movie; 
    }
    
    /*DTO salida, para devolver al cliente */
    public MovieResponseDTO toDTO(Movie movie) {
        List<String> genreNames = new ArrayList<>();
        if (movie.getGenres() != null) {
            for (Genre genre : movie.getGenres()) {
                genreNames.add(genre.getName());
            }
        }
        return new MovieResponseDTO(movie.getId(), movie.getTitle(), genreNames);
    }
}
