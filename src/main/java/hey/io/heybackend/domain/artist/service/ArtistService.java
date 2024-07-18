package hey.io.heybackend.domain.artist.service;

import hey.io.heybackend.common.exception.BusinessException;
import hey.io.heybackend.common.exception.ErrorCode;
import hey.io.heybackend.common.response.SliceResponse;
import hey.io.heybackend.domain.album.dto.AlbumResponse;
import hey.io.heybackend.domain.album.repository.AlbumRepository;
import hey.io.heybackend.domain.artist.domain.ArtistEntity;
import hey.io.heybackend.domain.artist.dto.ArtistListResponse;
import hey.io.heybackend.domain.artist.dto.ArtistResponse;
import hey.io.heybackend.domain.artist.repository.ArtistRepository;
import hey.io.heybackend.domain.performance.domain.BoxOfficeRank;
import hey.io.heybackend.domain.performance.dto.PerformanceResponse;
import hey.io.heybackend.domain.performance.repository.BoxOfficeRankRepository;
import hey.io.heybackend.domain.performance.repository.PerformanceArtistRepository;
import hey.io.heybackend.domain.performance.repository.PerformanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final PerformanceRepository performanceRepository;
    private final PerformanceArtistRepository performanceArtistRepository;
    private final AlbumRepository albumRepository;
    private final BoxOfficeRankRepository boxOfficeRankRepository;


    public ArtistResponse getArtist(String artistId) {
        ArtistEntity artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new BusinessException(ErrorCode.ARTIST_NOT_FOUND));

        return new ArtistResponse(artist);
    }

    public SliceResponse<ArtistListResponse> searchArtists(String keyword, int size, int page, Sort.Direction direction) {
        Slice<ArtistListResponse> artists = artistRepository.searchArtists(keyword, Pageable.ofSize(size).withPage(page), direction);
        return new SliceResponse<>(artists);
    }

    public SliceResponse<AlbumResponse> getAlbums(String artistId, int size, int page, Sort.Direction direction) {

        ArtistEntity artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new BusinessException(ErrorCode.ARTIST_NOT_FOUND));

        Slice<AlbumResponse> albums = albumRepository.getArtistAlbums(artist, Pageable.ofSize(size).withPage(page), direction);

        return new SliceResponse<>(albums);
    }

    public SliceResponse<PerformanceResponse> getArtistPerformances(String artistId, int size, int page, Sort.Direction direction) {
        Slice<PerformanceResponse> performances = performanceArtistRepository.getArtistPerformances(artistId, Pageable.ofSize(size).withPage(page), direction);
        return new SliceResponse<>(performances);
    }

    public List<ArtistListResponse> getArtistRank() {

        List<BoxOfficeRank> performances = boxOfficeRankRepository.findAll();
        String performanceIds = performances.get(0).getPerformanceIds();

        List<String> performanceIdList = Arrays.asList(performanceIds.split("\\|"));

        List<ArtistListResponse> artistListResponses = new ArrayList<>();

        for (String performanceId : performanceIdList) {
            List<ArtistListResponse> artists = performanceArtistRepository.getPerformanceArtists(performanceId);
            artistListResponses.addAll(artists);
        }
        return artistListResponses;
    }


}
