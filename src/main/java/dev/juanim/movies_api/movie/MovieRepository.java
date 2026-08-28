package dev.juanim.movies_api.movie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByTitleContainingIgnoreCase(String title);

    List<Movie> findByGenres_NameContainingIgnoreCase(String name);
}   /* _Name se usa para buscar el campo NAME, porque por defect esta el id */