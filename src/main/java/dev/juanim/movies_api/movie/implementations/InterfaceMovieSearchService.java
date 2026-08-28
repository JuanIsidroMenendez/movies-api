package dev.juanim.movies_api.movie.implementations;

import java.util.List;

import dev.juanim.movies_api.movie.Movie;

public interface InterfaceMovieSearchService {

    public List<Movie> findByTitle(String title);
    
}

/* No es genérica porque se ciñe a <Movie>. Las genéricas previas
hacen uso de Type <T> */