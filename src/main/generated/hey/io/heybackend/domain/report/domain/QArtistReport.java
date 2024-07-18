package hey.io.heybackend.domain.report.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArtistReport is a Querydsl query type for ArtistReport
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArtistReport extends EntityPathBase<ArtistReport> {

    private static final long serialVersionUID = 1783114901L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArtistReport artistReport = new QArtistReport("artistReport");

    public final hey.io.heybackend.common.entity.QBaseEntity _super = new hey.io.heybackend.common.entity.QBaseEntity(this);

    public final hey.io.heybackend.domain.artist.domain.QArtistEntity artist;

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<String, StringPath> type = this.<String, StringPath>createList("type", String.class, StringPath.class, PathInits.DIRECT2);

    public final hey.io.heybackend.domain.user.domain.QUser user;

    public QArtistReport(String variable) {
        this(ArtistReport.class, forVariable(variable), INITS);
    }

    public QArtistReport(Path<? extends ArtistReport> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArtistReport(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArtistReport(PathMetadata metadata, PathInits inits) {
        this(ArtistReport.class, metadata, inits);
    }

    public QArtistReport(Class<? extends ArtistReport> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.artist = inits.isInitialized("artist") ? new hey.io.heybackend.domain.artist.domain.QArtistEntity(forProperty("artist")) : null;
        this.user = inits.isInitialized("user") ? new hey.io.heybackend.domain.user.domain.QUser(forProperty("user")) : null;
    }

}

