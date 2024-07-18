package hey.io.heybackend.domain.follow.repository;

import hey.io.heybackend.domain.artist.domain.ArtistEntity;
import hey.io.heybackend.domain.follow.domain.ArtistFollow;
import hey.io.heybackend.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FollowArtistRepository extends JpaRepository<ArtistFollow, Long>, FollowArtistQueryRepository {

    Optional<ArtistFollow> findByUserAndArtist(User user, ArtistEntity artist);

    @Modifying
    @Query("delete from ArtistFollow a where a.artist.id in :ids")
    void deleteAllByIds(@Param("ids") List<String> artistIds);
}
