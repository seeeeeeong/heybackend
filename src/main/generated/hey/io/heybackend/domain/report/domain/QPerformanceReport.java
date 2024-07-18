package hey.io.heybackend.domain.report.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPerformanceReport is a Querydsl query type for PerformanceReport
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPerformanceReport extends EntityPathBase<PerformanceReport> {

    private static final long serialVersionUID = -252590966L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPerformanceReport performanceReport = new QPerformanceReport("performanceReport");

    public final hey.io.heybackend.common.entity.QBaseEntity _super = new hey.io.heybackend.common.entity.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final hey.io.heybackend.domain.performance.domain.QPerformance performance;

    public final ListPath<String, StringPath> type = this.<String, StringPath>createList("type", String.class, StringPath.class, PathInits.DIRECT2);

    public final hey.io.heybackend.domain.user.domain.QUser user;

    public QPerformanceReport(String variable) {
        this(PerformanceReport.class, forVariable(variable), INITS);
    }

    public QPerformanceReport(Path<? extends PerformanceReport> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPerformanceReport(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPerformanceReport(PathMetadata metadata, PathInits inits) {
        this(PerformanceReport.class, metadata, inits);
    }

    public QPerformanceReport(Class<? extends PerformanceReport> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.performance = inits.isInitialized("performance") ? new hey.io.heybackend.domain.performance.domain.QPerformance(forProperty("performance"), inits.get("performance")) : null;
        this.user = inits.isInitialized("user") ? new hey.io.heybackend.domain.user.domain.QUser(forProperty("user")) : null;
    }

}

