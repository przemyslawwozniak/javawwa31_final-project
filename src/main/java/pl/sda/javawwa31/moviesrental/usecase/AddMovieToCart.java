package pl.sda.javawwa31.moviesrental.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.javawwa31.moviesrental.domain.model.Movie;
import pl.sda.javawwa31.moviesrental.usecase.exception.MovieDoesNotExistInCatalogue;
import pl.sda.javawwa31.moviesrental.usecase.port.CartService;
import pl.sda.javawwa31.moviesrental.usecase.port.MoviesRepository;

import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AddMovieToCart {

    private final GetMoviesInCart getMoviesInCart;

    private final MoviesRepository moviesRepository;
    private final CartService cartService;

    
    public Map<Movie, Integer> add(Long movieId) throws MovieDoesNotExistInCatalogue {
        Optional<Movie> movie = moviesRepository.findById(movieId);
        if(movie.isPresent()) {
            cartService.add(movieId);
            return getMoviesInCart.getMovies();
        }
        else {
            throw new MovieDoesNotExistInCatalogue();
        }
    }

}
