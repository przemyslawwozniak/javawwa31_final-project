package pl.sda.javawwa31.moviesrental.usecase.port;

import java.util.Map;

public interface CartService {

    Map<Long, Integer> add(Long movieId);

    Map<Long, Integer> getCartEntries();

}
