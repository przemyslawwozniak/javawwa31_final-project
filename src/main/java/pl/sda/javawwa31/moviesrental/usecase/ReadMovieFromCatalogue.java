package pl.sda.javawwa31.moviesrental.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.javawwa31.moviesrental.domain.model.Movie;
import pl.sda.javawwa31.moviesrental.usecase.exception.MovieDoesNotExistInCatalogue;
import pl.sda.javawwa31.moviesrental.usecase.port.MoviesRepository;

@Component
@RequiredArgsConstructor
public class ReadMovieFromCatalogue {

    private final MoviesRepository moviesRepository;

    public Movie readByTitle(String title) throws MovieDoesNotExistInCatalogue {
        return moviesRepository.findByTitle(title)
                .orElseThrow(MovieDoesNotExistInCatalogue::new);
    }

}

