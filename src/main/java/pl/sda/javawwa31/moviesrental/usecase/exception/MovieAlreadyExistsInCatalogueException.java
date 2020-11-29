package pl.sda.javawwa31.moviesrental.usecase.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MovieAlreadyExistsInCatalogueException extends Exception {

    public MovieAlreadyExistsInCatalogueException(String title) {
        super(title + " already exists in movies catalogue!");
    }
}
