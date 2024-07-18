package hey.io.heybackend.domain.performance.repository;

import hey.io.heybackend.domain.performance.domain.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, String>, PerformanceQueryRepository {

    List<Performance> findTop5ByOrderByCreatedAtDesc();

}
