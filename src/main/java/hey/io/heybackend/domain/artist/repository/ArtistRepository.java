package hey.io.heybackend.domain.artist.repository;

import hey.io.heybackend.domain.artist.domain.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, String>, ArtistQueryRepository {
}
