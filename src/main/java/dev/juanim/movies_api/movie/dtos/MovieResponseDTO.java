package dev.juanim.movies_api.movie.dtos;

import java.util.List;

/* Lo que debe salir con id.
En Request van los id, y en Response los String */
public record MovieResponseDTO(Long id, String title, List<String> genres) {

}
