package dev.juanim.movies_api.movie.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
/* Esto es lo que entra, con validación pero sin id */
public record MovieRequestDTO (
    @NotBlank(message = "Title cannot be empty")
    @NotNull(message = "Title cannot be null")
    String title
){
}
