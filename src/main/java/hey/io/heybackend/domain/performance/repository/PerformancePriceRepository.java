package hey.io.heybackend.domain.performance.repository;

import hey.io.heybackend.domain.performance.domain.PerformancePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformancePriceRepository extends JpaRepository<PerformancePrice, Long> {
}
