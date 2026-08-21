package dev.juanim.movies_api.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity; /* Indica vía @ que la clase representa una tabla */
import jakarta.persistence.Table;  /* Anotación para espcificar el nombre de la tabla */

import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "movies")
public class Movie {

    @Id /* Marcará el campo id como PK */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Análogo de generatedId, pero gestionado por DB */
    private Long id;

    private String title;

    @ManyToOne /* Muchas películas apuntan a un año */
    @JoinColumn(name = "year_id") /* La columna FK en la tabla movies se llama year_id */
    private ReleaseYear releaseYear;

    /* Mantener constructor vacío para JPA */
    public Movie() {
    }

    public Movie(String title, ReleaseYear releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }
    @ManyToMany
    @JoinTable(
        name = "movie_genre",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ReleaseYear getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(ReleaseYear releaseYear) {
        this.releaseYear = releaseYear;
    }
    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}