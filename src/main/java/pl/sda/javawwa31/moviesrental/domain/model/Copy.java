package pl.sda.javawwa31.moviesrental.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Copy {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Movie movie;

}
