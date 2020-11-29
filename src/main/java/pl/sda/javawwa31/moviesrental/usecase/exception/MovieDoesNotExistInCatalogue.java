package pl.sda.javawwa31.moviesrental.usecase.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MovieDoesNotExistInCatalogue extends Exception {

    public MovieDoesNotExistInCatalogue(String title) {
        super(title + " does not exist in catalogue!");
    }

}
