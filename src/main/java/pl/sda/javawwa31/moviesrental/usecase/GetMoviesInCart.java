package pl.sda.javawwa31.moviesrental.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.javawwa31.moviesrental.domain.model.Movie;
import pl.sda.javawwa31.moviesrental.usecase.port.CartService;
import pl.sda.javawwa31.moviesrental.usecase.port.MoviesRepository;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetMoviesInCart {

    private final MoviesRepository moviesRepository;
    private final CartService cartService;

    public Map<Movie, Integer> getMovies() {
        return cartService.getCartEntries().entrySet().stream()
                .map(this::mapEntryWithLongToEntryWithMovie)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Map.Entry<Movie, Integer> mapEntryWithLongToEntryWithMovie(Map.Entry<Long, Integer> cartEntries) {
        return new AbstractMap.SimpleEntry<Movie, Integer>(mapLongToMovie(cartEntries.getKey()), cartEntries.getValue());
    }

    private Movie mapLongToMovie(Long movieId) {
        return moviesRepository.findById(movieId).get();
    }

}
