package hey.io.heybackend.domain.report.repository;

import hey.io.heybackend.domain.report.domain.ArtistReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistReportRepository extends JpaRepository<ArtistReport, Long> {
}
