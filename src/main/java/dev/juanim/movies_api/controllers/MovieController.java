package dev.juanim.movies_api.controllers;

import dev.juanim.movies_api.models.Movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @GetMapping
    public List<Movie> getAllMovies() {
        return List.of(
                new Movie(1L, "The Matrix", 1999),
                new Movie(2L, "Inception", 2010)
        );
    }
}