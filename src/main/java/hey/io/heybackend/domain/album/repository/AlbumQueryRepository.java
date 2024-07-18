package hey.io.heybackend.domain.album.repository;

import hey.io.heybackend.domain.album.dto.AlbumResponse;
import hey.io.heybackend.domain.artist.domain.ArtistEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface AlbumQueryRepository {

    List<String> findAllIds();

    Slice<AlbumResponse> getArtistAlbums(ArtistEntity artist, Pageable pageable, Sort.Direction direction);
}
