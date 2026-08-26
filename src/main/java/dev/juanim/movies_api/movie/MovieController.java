package dev.juanim.movies_api.movie;

import dev.juanim.movies_api.implementations.InterfaceGenericGetService;
import dev.juanim.movies_api.implementations.InterfaceGenericWriteService;
import dev.juanim.movies_api.movie.dtos.MovieRequestDTO;
import dev.juanim.movies_api.movie.dtos.MovieResponseDTO;
import dev.juanim.movies_api.movie.mappers.MovieMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
/* Imports relativos a interfaz Write */
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;


import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final InterfaceGenericGetService<Movie> movieGetService;
    private final InterfaceGenericWriteService<Movie> movieWriteService;
  

    public MovieController(
        InterfaceGenericGetService<Movie> movieGetService,
        InterfaceGenericWriteService<Movie> movieWriteService)
        {
        this.movieGetService = movieGetService;
        this.movieWriteService = movieWriteService;
    }
    /* Actualizado con List<MovieResponseDTO> */
    @GetMapping
    public List<MovieResponseDTO> getAllMovies() {
        return movieGetService.getEntities()
            .stream()               /* Recorre cada movie, convierte en DTO y recoge la lista */
            .map(MovieMapper::toDTO)
            .toList();
    }

    @GetMapping("{id}") /* Por que aquí sin /? */
    public MovieResponseDTO getMovieById(@PathVariable Long id) {
        return MovieMapper.toDTO(movieGetService.getById(id));
    }

    @PostMapping /* recibe MovieRequesto DTO con @Valid y devuelve MovieResponseDTO */
    public MovieResponseDTO createMovie(@Valid @RequestBody MovieRequestDTO dto) {
        Movie movie = MovieMapper.toEntity(dto);
        return MovieMapper.toDTO(movieWriteService.create(movie));
    }
    
    @PutMapping("/{id}")
    public MovieResponseDTO updateMovie(@PathVariable Long id, @RequestBody MovieRequestDTO dto) {
        Movie movie = MovieMapper.toEntity(dto);
        return MovieMapper.toDTO(movieWriteService.update(id, movie));

    }
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieWriteService.delete(id);
    }
}