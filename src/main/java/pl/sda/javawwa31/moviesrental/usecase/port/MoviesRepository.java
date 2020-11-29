package pl.sda.javawwa31.moviesrental.usecase.port;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.javawwa31.moviesrental.domain.model.Movie;

import java.util.Optional;

@Repository
public interface MoviesRepository extends CrudRepository<Movie, Long> {

    Optional<Movie> findByTitle(String title);

}
