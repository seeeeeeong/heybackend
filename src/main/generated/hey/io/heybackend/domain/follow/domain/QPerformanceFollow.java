package hey.io.heybackend.domain.follow.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPerformanceFollow is a Querydsl query type for PerformanceFollow
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPerformanceFollow extends EntityPathBase<PerformanceFollow> {

    private static final long serialVersionUID = -893510870L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPerformanceFollow performanceFollow = new QPerformanceFollow("performanceFollow");

    public final hey.io.heybackend.common.entity.QBaseEntity _super = new hey.io.heybackend.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final hey.io.heybackend.domain.performance.domain.QPerformance performance;

    public final hey.io.heybackend.domain.user.domain.QUser user;

    public QPerformanceFollow(String variable) {
        this(PerformanceFollow.class, forVariable(variable), INITS);
    }

    public QPerformanceFollow(Path<? extends PerformanceFollow> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPerformanceFollow(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPerformanceFollow(PathMetadata metadata, PathInits inits) {
        this(PerformanceFollow.class, metadata, inits);
    }

    public QPerformanceFollow(Class<? extends PerformanceFollow> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.performance = inits.isInitialized("performance") ? new hey.io.heybackend.domain.performance.domain.QPerformance(forProperty("performance"), inits.get("performance")) : null;
        this.user = inits.isInitialized("user") ? new hey.io.heybackend.domain.user.domain.QUser(forProperty("user")) : null;
    }

}

