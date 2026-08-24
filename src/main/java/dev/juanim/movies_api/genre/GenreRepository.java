package dev.juanim.movies_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.juanim.movies_api.genre.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}