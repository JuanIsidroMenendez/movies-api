package dev.juanim.movies_api.movie;

import dev.juanim.movies_api.implementations.InterfaceGenericGetService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final InterfaceGenericGetService<Movie> movieService;

    public MovieController(InterfaceGenericGetService<Movie> movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getEntities();
    }

    @GetMapping("/id")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getById(id);
    }
    
}