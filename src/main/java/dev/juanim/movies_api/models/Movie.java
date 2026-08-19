package dev.juanim.movies_api.models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Entity; /* Indica vía @ que la clase representa una tabla */
import jakarta.persistence.Table;  /* Anotación para espcificar el nombre de la tabla */
import jakarta.persistence.Column; /* Por eso daba error: Sin notación column, no lo reconocía */

@Entity 
@Table(name = "movies")
public class Movie {

    @Id /* Marcará el campo id como PK */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Análogo de generatedId, pero gestionado por DB */
    private Long id;
    

    private String title;

    @Column(name = "release_year") /* year palabra reservada? */
    private int year;

    /* Mantener constructor vacío para JPA */
    public Movie() {
    }

    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
    }

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}