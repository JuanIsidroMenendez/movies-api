package dev.juanim.movies_api.movie.exceptions;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(Long id) {
        super("Movie with id" + id + "not found");
    } 
}
