package dev.juanim.movies_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; /* Marcador de PK */
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    /* De nuevo, constructor vacío para Java Persistence API */
    public Genre(){

    }
    public Genre(String name) {
        this.name = name;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName () {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}