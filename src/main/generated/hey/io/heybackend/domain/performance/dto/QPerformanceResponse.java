package hey.io.heybackend.domain.performance.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * hey.io.heybackend.domain.performance.dto.QPerformanceResponse is a Querydsl Projection type for PerformanceResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QPerformanceResponse extends ConstructorExpression<PerformanceResponse> {

    private static final long serialVersionUID = -316121734L;

    public QPerformanceResponse(com.querydsl.core.types.Expression<String> id, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<java.time.LocalDate> startDate, com.querydsl.core.types.Expression<java.time.LocalDate> endDate, com.querydsl.core.types.Expression<String> theater, com.querydsl.core.types.Expression<String> poster, com.querydsl.core.types.Expression<hey.io.heybackend.domain.performance.domain.enums.PerformanceStatus> status, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdAt) {
        super(PerformanceResponse.class, new Class<?>[]{String.class, String.class, java.time.LocalDate.class, java.time.LocalDate.class, String.class, String.class, hey.io.heybackend.domain.performance.domain.enums.PerformanceStatus.class, java.time.LocalDateTime.class}, id, title, startDate, endDate, theater, poster, status, createdAt);
    }

}

