package hey.io.heybackend.domain.report.service;

import hey.io.heybackend.common.exception.BusinessException;
import hey.io.heybackend.common.exception.ErrorCode;
import hey.io.heybackend.domain.artist.domain.ArtistEntity;
import hey.io.heybackend.domain.artist.repository.ArtistRepository;
import hey.io.heybackend.domain.performance.domain.Performance;
import hey.io.heybackend.domain.performance.repository.PerformanceRepository;
import hey.io.heybackend.domain.report.domain.ArtistReport;
import hey.io.heybackend.domain.report.domain.PerformanceReport;
import hey.io.heybackend.domain.report.dto.ReportRequest;
import hey.io.heybackend.domain.report.dto.ReportResponse;
import hey.io.heybackend.domain.report.repository.ArtistReportRepository;
import hey.io.heybackend.domain.report.repository.PerformanceReportRepository;
import hey.io.heybackend.domain.user.domain.User;
import hey.io.heybackend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReportService {

    private final PerformanceRepository performanceRepository;
    private final UserRepository userRepository;
    private final PerformanceReportRepository performanceReportRepository;
    private final ArtistRepository artistRepository;
    private final ArtistReportRepository artistReportRepository;


    @Transactional
    public ReportResponse reportPerformance(String performanceId, Long userId, ReportRequest request) {
        Performance performance = performanceRepository.findById(performanceId)
                .orElseThrow(() -> new BusinessException(ErrorCode.PERFORMANCE_NOT_FOUND));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

        PerformanceReport performanceReport = PerformanceReport.of(request, user, performance);
        performanceReportRepository.save(performanceReport);

        return new ReportResponse(performanceId, userId);
    }

    @Transactional
    public ReportResponse reportArtist(String artistId, Long userId, ReportRequest request) {
        ArtistEntity artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new BusinessException(ErrorCode.ARTIST_NOT_FOUND));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

        ArtistReport artistReport = ArtistReport.of(request, user, artist);
        artistReportRepository.save(artistReport);

        return new ReportResponse(artistId, userId);

    }

}
