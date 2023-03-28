package db.repository.sports;

import db.entities.models.surface.Arena;
import db.entities.models.surface.Stadium;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StadiumRepository extends CrudRepository<Stadium, Long> {
    @Query(name = "getStadiumByCapacity", nativeQuery = true)
    Iterable<Stadium> getStadiumByCapacity(Long capacity);
    @Query(name = "getStadiumById", nativeQuery = true)
    Stadium getStadiumById(Long id);
}
