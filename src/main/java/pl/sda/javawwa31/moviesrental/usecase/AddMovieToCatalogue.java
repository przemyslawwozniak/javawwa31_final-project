package pl.sda.javawwa31.moviesrental.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.javawwa31.moviesrental.domain.model.Movie;
import pl.sda.javawwa31.moviesrental.usecase.exception.MovieAlreadyExistsInCatalogueException;
import pl.sda.javawwa31.moviesrental.usecase.port.MoviesRepository;

@Component
@RequiredArgsConstructor
public class AddMovieToCatalogue {

    private final MoviesRepository moviesRepository;

    public Movie add(Movie movie) throws MovieAlreadyExistsInCatalogueException {
        /*return moviesRepository.findByTitle(movie.getTitle())
                .map(moviesRepository::save)
                .orElseThrow(MovieAlreadyExistsInCatalogueException::new);*/

        if(moviesRepository.findByTitle(movie.getTitle()).isPresent()) {
            throw new MovieAlreadyExistsInCatalogueException(movie.getTitle());
        }
        return moviesRepository.save(movie);
    }
}
