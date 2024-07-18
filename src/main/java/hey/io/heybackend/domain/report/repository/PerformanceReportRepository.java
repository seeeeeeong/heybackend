package hey.io.heybackend.domain.report.repository;

import hey.io.heybackend.domain.report.domain.PerformanceReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceReportRepository extends JpaRepository<PerformanceReport, String> {
}
