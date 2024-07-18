package hey.io.heybackend.domain.report.domain;

import hey.io.heybackend.common.entity.BaseEntity;
import hey.io.heybackend.domain.artist.domain.ArtistEntity;
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
public class ArtistReport extends BaseEntity {

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
    @JoinColumn(name = "artist_id")
    private ArtistEntity artist;

    @Builder
    private ArtistReport(User user, List<String> type, String content, ArtistEntity artist) {
        this.user = user;
        this.type = type;
        this.content = content;
        this.artist = artist;
    }

    public static ArtistReport of(ReportRequest request, User user, ArtistEntity artist) {
        return ArtistReport.builder()
                .user(user)
                .type(request.getType())
                .content(request.getContent())
                .artist(artist)
                .build();
    }
}
