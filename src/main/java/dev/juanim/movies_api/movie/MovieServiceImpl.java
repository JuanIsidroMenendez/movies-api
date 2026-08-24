package dev.juanim.movies_api.movie;

/* Aplicar la interfaz segregada de GetService */
import dev.juanim.movies_api.implementations.InterfaceGenericGetService;
import dev.juanim.movies_api.implementations.InterfaceGenericWriteService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service /* Identifica como servicio. Similar a RestController y Repository*/
public class MovieServiceImpl implements InterfaceGenericGetService<Movie>, InterfaceGenericWriteService<Movie> {

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

    @Override /* Con la nueva interfaz, nuevo contrato a cumplir */
    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }
    @Override 
    public Movie update(Long id, Movie movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }
    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

}


