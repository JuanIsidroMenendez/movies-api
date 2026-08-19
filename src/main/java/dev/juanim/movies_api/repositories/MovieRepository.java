package dev.juanim.movies_api.repositories;

import dev.juanim.movies_api.models.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}