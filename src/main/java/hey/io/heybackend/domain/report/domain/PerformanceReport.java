package hey.io.heybackend.domain.report.domain;

import hey.io.heybackend.common.entity.BaseEntity;
import hey.io.heybackend.domain.performance.domain.Performance;
import hey.io.heybackend.domain.report.dto.ReportRequest;
import hey.io.heybackend.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PerformanceReport extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> type = new ArrayList<>();

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id")
    private Performance performance;

    @Builder
    private PerformanceReport(User user, List<String> type, String content, Performance performance) {
        this.user = user;
        this.type = type;
        this.content = content;
        this.performance = performance;
    }

    public static PerformanceReport of(ReportRequest request, User user, Performance performance) {
        return PerformanceReport.builder()
                .user(user)
                .type(request.getType())
                .content(request.getContent())
                .performance(performance)
                .build();
    }

}
