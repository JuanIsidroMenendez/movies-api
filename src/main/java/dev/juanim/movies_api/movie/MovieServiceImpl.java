package dev.juanim.movies_api.movie;

/* Aplicar la interfaz segregada de GetService */
import dev.juanim.movies_api.implementations.InterfaceGenericGetService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service /* Identifica como servicio. Similar a RestController y Repository*/
public class MovieServiceImpl implements InterfaceGenericGetService<Movie> {

private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    
    @Override
    public List<Movie> getEntities() {
        return movieRepository.findAll();
    }
    @Override /* No es sobrescribir, es CUMPLIMIENTO del contrato. El método cumple lo marcado por la interfaz */
    public Movie getById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
}
