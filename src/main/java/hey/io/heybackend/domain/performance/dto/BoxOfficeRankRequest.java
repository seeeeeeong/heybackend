package hey.io.heybackend.domain.performance.dto;

import hey.io.heybackend.domain.performance.domain.enums.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Schema(description = "BoxOfficeRank request")
public class BoxOfficeRankRequest {

    @Schema(description = "기간 (DAY / MONTH / WEEK)")
    private TimePeriod timePeriod;
}
