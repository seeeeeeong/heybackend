package hey.io.heybackend.domain.follow.domain;

import hey.io.heybackend.common.entity.BaseEntity;
import hey.io.heybackend.domain.artist.domain.ArtistEntity;
import hey.io.heybackend.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArtistFollow extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private ArtistEntity artist;

    @Builder
    private ArtistFollow(User user, ArtistEntity artist) {
        this.user = user;
        this.artist = artist;
    }

    public static ArtistFollow of(User user, ArtistEntity artist) {
        return ArtistFollow.builder()
                .user(user)
                .artist(artist)
                .build();
    }
}
