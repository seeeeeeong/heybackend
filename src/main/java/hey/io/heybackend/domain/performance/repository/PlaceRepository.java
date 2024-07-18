package hey.io.heybackend.domain.performance.repository;

import hey.io.heybackend.domain.performance.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, String> {

    Optional<Place> findById(String id);

}
