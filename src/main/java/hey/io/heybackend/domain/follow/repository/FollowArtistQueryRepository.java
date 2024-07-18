package hey.io.heybackend.domain.follow.repository;

import hey.io.heybackend.domain.artist.dto.ArtistListResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

public interface FollowArtistQueryRepository {

    Slice<ArtistListResponse> getFollowArtists(Long userId, Pageable pageable, Sort.Direction direction);


}
