package hey.io.heybackend.domain.follow.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArtistFollow is a Querydsl query type for ArtistFollow
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArtistFollow extends EntityPathBase<ArtistFollow> {

    private static final long serialVersionUID = 766171407L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArtistFollow artistFollow = new QArtistFollow("artistFollow");

    public final hey.io.heybackend.common.entity.QBaseEntity _super = new hey.io.heybackend.common.entity.QBaseEntity(this);

    public final hey.io.heybackend.domain.artist.domain.QArtistEntity artist;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final hey.io.heybackend.domain.user.domain.QUser user;

    public QArtistFollow(String variable) {
        this(ArtistFollow.class, forVariable(variable), INITS);
    }

    public QArtistFollow(Path<? extends ArtistFollow> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArtistFollow(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArtistFollow(PathMetadata metadata, PathInits inits) {
        this(ArtistFollow.class, metadata, inits);
    }

    public QArtistFollow(Class<? extends ArtistFollow> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.artist = inits.isInitialized("artist") ? new hey.io.heybackend.domain.artist.domain.QArtistEntity(forProperty("artist")) : null;
        this.user = inits.isInitialized("user") ? new hey.io.heybackend.domain.user.domain.QUser(forProperty("user")) : null;
    }

}

