package dev.juanim.movies_api.repositories;

import dev.juanim.movies_api.models.Genre;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}