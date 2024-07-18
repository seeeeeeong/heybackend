package hey.io.heybackend.domain.performance.repository;

import hey.io.heybackend.domain.performance.domain.Performance;
import hey.io.heybackend.domain.performance.dto.PerformanceFilterRequest;
import hey.io.heybackend.domain.performance.dto.PerformanceResponse;
import hey.io.heybackend.domain.performance.dto.PerformanceSearchRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;

public interface PerformanceQueryRepository {

    List<String> findAllIds();
    Slice<PerformanceResponse> getPerformancesByCondition(PerformanceFilterRequest request, Pageable pageable, Direction direction);
    Slice<PerformanceResponse> searchPerformances(PerformanceSearchRequest request, Pageable pageable, Direction direction);
    List<Performance> getPerformancesByStartDate();

}
