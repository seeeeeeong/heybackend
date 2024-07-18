package hey.io.heybackend.domain.performance.service;

import hey.io.heybackend.common.exception.BusinessException;
import hey.io.heybackend.common.exception.ErrorCode;
import hey.io.heybackend.common.response.SliceResponse;
import hey.io.heybackend.domain.artist.dto.ArtistListResponse;
import hey.io.heybackend.domain.performance.domain.BoxOfficeRank;
import hey.io.heybackend.domain.performance.domain.Performance;
import hey.io.heybackend.domain.performance.domain.Place;
import hey.io.heybackend.domain.performance.dto.*;
import hey.io.heybackend.domain.performance.mapper.PerformanceMapper;
import hey.io.heybackend.domain.performance.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PerformanceService {

    private final PerformancePriceRepository performancePriceRepository;
    private final PerformanceRepository performanceRepository;
    private final BoxOfficeRankRepository boxOfficeRankRepository;
    private final PlaceRepository placeRepository;
    private final PerformanceArtistRepository performanceArtistRepository;
    private final CacheManager cacheManager;


    @Cacheable(
            key = "T(hey.io.heybackend.common.config.CacheKeyGenerator).generateKey(#request.statuses, #size, #page, #request.visit)",
            value = "PERFORMANCE",
            cacheManager = "redisCacheManager"
    )
    public SliceResponse<PerformanceResponse> getPerformancesByCondition(PerformanceFilterRequest request, int size, int page, Direction direction) {
        Slice<PerformanceResponse> performances = performanceRepository.getPerformancesByCondition(request, Pageable.ofSize(size).withPage(page), direction);

        return new SliceResponse<>(performances);
    }

    public SliceResponse<PerformanceResponse> searchPerformances(PerformanceSearchRequest request, int size, int page, Direction direction) {
        Slice<PerformanceResponse> performances = performanceRepository.searchPerformances(request, Pageable.ofSize(size).withPage(page), direction);
        return new SliceResponse<>(performances);
    }

    public List<PerformanceResponse> getNewPerformances() {
        List<Performance> newPerformances = performanceRepository.findTop5ByOrderByCreatedAtDesc();

        return newPerformances.stream()
                .map(PerformanceResponse::new)
                .collect(Collectors.toList());
    }

    public List<PerformanceResponse> getBoxOfficeRank(BoxOfficeRankRequest request) {
        BoxOfficeRank boxOfficeRank = boxOfficeRankRepository.findBoxOfficeRank(request)
                .orElseThrow(() -> new BusinessException(ErrorCode.PERFORMANCE_NOT_FOUND));

        String[] performanceIds = boxOfficeRank.getPerformanceIds().split("\\|");

        List<Performance> performanceList = performanceRepository.findAllById(Arrays.asList(performanceIds));

        return performanceList.stream()
                .map(PerformanceResponse::new)
                .collect(Collectors.toList());
    }

    public PerformanceDetailResponse getPerformance(String performanceId) {

        Performance performance = performanceRepository.findById(performanceId)
                .orElseThrow(() -> new BusinessException(ErrorCode.PERFORMANCE_NOT_FOUND));

        return getPerformanceDetailResponse(performance);
    }

    public List<ArtistListResponse> getPerformanceArtists(String performanceId) {

        List<ArtistListResponse> performanceArtist = performanceArtistRepository.getPerformanceArtists(performanceId);

        return performanceArtist;
    }

    private PerformanceDetailResponse getPerformanceDetailResponse(Performance performance) {
        PerformanceDetailResponse performanceDetailResponse = PerformanceMapper.INSTANCE.toPerformanceDto(performance);
        performanceDetailResponse.updateStoryUrls(performance.getStoryUrls());

        Place place = performance.getPlace();
        if (!ObjectUtils.isEmpty(place)) {
            performanceDetailResponse.updateLocation(place.getLatitude(), place.getLongitude());
            performanceDetailResponse.setAddress(place.getAddress());
            performanceDetailResponse.setPlaceId(place.getId());
        }
        return performanceDetailResponse;
    }

}
