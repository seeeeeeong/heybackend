package hey.io.heybackend.domain.album.repository;

import hey.io.heybackend.domain.album.domain.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, String>, AlbumQueryRepository {
}
