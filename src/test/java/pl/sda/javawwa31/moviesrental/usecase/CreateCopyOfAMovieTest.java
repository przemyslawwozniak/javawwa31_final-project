package pl.sda.javawwa31.moviesrental.usecase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.javawwa31.moviesrental.domain.model.Copy;
import pl.sda.javawwa31.moviesrental.domain.model.Movie;
import pl.sda.javawwa31.moviesrental.usecase.exception.MovieDoesNotExistInCatalogue;

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
        Assertions.assertThat(copy.getMovie()).isEqualTo(movie);    //mozliwe dzieki prawidlowej implementacji equals()
        //Assertions.assertThat(copy.getMovie().getId()).isEqualTo(movie.getId());
        //Assertions.assertThat(copy.getMovie().getTitle()).isEqualTo(movie.getTitle());
    }

    @Test
    void cannot_create_a_copy_of_non_existing_movie() {
        //given

        //when

        //then
        Assertions.assertThatExceptionOfType(MovieDoesNotExistInCatalogue.class)
                .isThrownBy(() -> createCopyOfAMovie.create(999L));
    }

}
