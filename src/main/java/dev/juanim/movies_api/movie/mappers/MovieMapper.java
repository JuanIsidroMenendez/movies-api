package dev.juanim.movies_api.movie.mappers;

import dev.juanim.movies_api.movie.Movie;
import dev.juanim.movies_api.movie.dtos.MovieRequestDTO;
import dev.juanim.movies_api.movie.dtos.MovieResponseDTO;

public class MovieMapper {
    /*DTO entrada, para guardar en BD */
    public static Movie toEntity(MovieRequestDTO dtoRequest) {
        Movie movie = new Movie();
        movie.setTitle(dtoRequest.title());
        return movie;
    }

    /*DTO salida, para devolver al cliente */
    public static MovieResponseDTO toDTO(Movie entity) {
        MovieResponseDTO dtoResponse = new MovieResponseDTO(entity.getId(), entity.getTitle());
        return dtoResponse;
    }
}
