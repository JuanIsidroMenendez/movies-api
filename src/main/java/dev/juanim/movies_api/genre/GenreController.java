package dev.juanim.movies_api.genre;

import dev.juanim.movies_api.implementations.InterfaceGenericGetService;
import dev.juanim.movies_api.implementations.InterfaceGenericWriteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final InterfaceGenericGetService<Genre> genreGetService;
    private final InterfaceGenericWriteService<Genre> genreWriteService;

    public GenreController(
            InterfaceGenericGetService<Genre> genreGetService,
            InterfaceGenericWriteService<Genre> genreWriteService) {
        this.genreGetService = genreGetService;
        this.genreWriteService = genreWriteService;
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreGetService.getEntities();
    }

    @PostMapping
    public Genre createGenre(@RequestBody Genre genre) {
        return genreWriteService.create(genre);
    }
}