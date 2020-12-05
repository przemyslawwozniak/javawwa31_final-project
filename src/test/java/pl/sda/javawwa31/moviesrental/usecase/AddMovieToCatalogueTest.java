package pl.sda.javawwa31.moviesrental.usecase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import pl.sda.javawwa31.moviesrental.domain.model.Movie;
import pl.sda.javawwa31.moviesrental.usecase.exception.MovieAlreadyExistsInCatalogueException;


@SpringBootTest
//moge nie czyscic kontekstu jezeli nie wykorzystuje ponownie danych z innych metod testowych
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)    //efekt: usuwa dane z repo pomiedzy testami
public class AddMovieToCatalogueTest {

    @Autowired private AddMovieToCatalogue addMovieToCatalogue;
    @Autowired private ReadMovieFromCatalogue readMovieFromCatalogue;

    @Test
    void add_new_movie_to_catalogue() throws Exception {
        //given
        Movie movie = new Movie();
        movie.setTitle("Ogniem i mieczem");

        //when
        Movie addedMovie = addMovieToCatalogue.add(movie);
        Movie readMovie = readMovieFromCatalogue.readByTitle(movie.getTitle());

        //then
        Assertions.assertThat(addedMovie).isEqualTo(readMovie);
    }

    @Test
    void cannot_add_movie_which_already_exists_in_catalogue() throws Exception {
        //given
        Movie movie = new Movie();
        movie.setTitle("Avatar");

        //when
        addMovieToCatalogue.add(movie);

        //then
        Assertions.assertThatExceptionOfType(MovieAlreadyExistsInCatalogueException.class)
                .isThrownBy(() -> addMovieToCatalogue.add(movie));
    }

}
