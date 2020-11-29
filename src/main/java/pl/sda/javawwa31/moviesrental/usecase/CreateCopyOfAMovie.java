package pl.sda.javawwa31.moviesrental.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.javawwa31.moviesrental.domain.model.Copy;
import pl.sda.javawwa31.moviesrental.domain.model.Movie;
import pl.sda.javawwa31.moviesrental.usecase.exception.MovieDoesNotExistInCatalogue;
import pl.sda.javawwa31.moviesrental.usecase.port.CopiesRepository;
import pl.sda.javawwa31.moviesrental.usecase.port.MoviesRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CreateCopyOfAMovie {

    private final CopiesRepository copiesRepository;
    private final MoviesRepository moviesRepository;

    public Copy create(Long movieId) throws MovieDoesNotExistInCatalogue {
        Optional<Movie> movie = moviesRepository.findById(movieId);
        if(movie.isPresent()) {
            Copy copy = new Copy();
            copy.setMovie(movie.get());
            return copiesRepository.save(copy);
        }
        else {
            throw new MovieDoesNotExistInCatalogue();
        }
    }
}
