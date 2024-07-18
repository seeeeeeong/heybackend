package hey.io.heybackend.domain.artist.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * hey.io.heybackend.domain.artist.dto.QArtistListResponse is a Querydsl Projection type for ArtistListResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QArtistListResponse extends ConstructorExpression<ArtistListResponse> {

    private static final long serialVersionUID = 1387683538L;

    public QArtistListResponse(com.querydsl.core.types.Expression<String> id, com.querydsl.core.types.Expression<String> artistName, com.querydsl.core.types.Expression<String> artistImage) {
        super(ArtistListResponse.class, new Class<?>[]{String.class, String.class, String.class}, id, artistName, artistImage);
    }

}

