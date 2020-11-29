package pl.sda.javawwa31.moviesrental.usecase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.javawwa31.moviesrental.domain.model.Copy;
import pl.sda.javawwa31.moviesrental.domain.model.Movie;

@SpringBootTest
public class CreateCopyOfAMovieTest {

    @Autowired private AddMovieToCatalogue addMovieToCatalogue;
    @Autowired private  CreateCopyOfAMovie createCopyOfAMovie;

    @Test
    void creates_copy_of_a_given_movie() throws Exception {
        //given
        Movie movie = new Movie();
        movie.setTitle("Ogniem i mieczem");
        movie = addMovieToCatalogue.add(movie);

        //when
        Copy copy = createCopyOfAMovie.create(movie.getId());

        //then
        Assertions.assertThat(copy.getMovie()).isEqualTo(movie);
    }

    @Test
    void cannot_create_a_copy_of_non_existing_movie() {

    }

}
