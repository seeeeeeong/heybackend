package hey.io.heybackend.domain.artist.repository;

import hey.io.heybackend.domain.artist.dto.ArtistListResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ArtistQueryRepository {

    List<String> findAllIds();

    Slice<ArtistListResponse> searchArtists(String keyword, Pageable pageable, Sort.Direction direction);

}
