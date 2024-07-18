package hey.io.heybackend.domain.performance.repository;

import hey.io.heybackend.domain.performance.domain.BoxOfficeRank;
import hey.io.heybackend.domain.performance.dto.BoxOfficeRankRequest;

import java.util.Optional;

public interface BoxOfficeRankQueryRepository {

    Optional<BoxOfficeRank> findBoxOfficeRank(BoxOfficeRankRequest request);

}
