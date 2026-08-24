package dev.juanim.movies_api.movie;

import dev.juanim.movies_api.implementations.InterfaceGenericGetService;
import dev.juanim.movies_api.implementations.InterfaceGenericWriteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
/* Imports relativos a interfaz Write */
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


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

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieGetService.getEntities();
    }

    @GetMapping("/id")
    public Movie getMovieById(@PathVariable Long id) {
        return movieGetService.getById(id);
    }

    @PostMapping /* @Request convierte el JSON entrante en Movie */
    public Movie createMovie(@RequestBody Movie movie) {
        return movieWriteService.create(movie);
    }
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return movieWriteService.update(id, movie); 
    }
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieWriteService.delete(id);
    }
}