package pl.sda.javawwa31.moviesrental.usecase.port;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.javawwa31.moviesrental.domain.model.Copy;

@Repository
public interface CopiesRepository extends CrudRepository<Copy, Long> {
}
