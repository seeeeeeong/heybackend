package hey.io.heybackend.domain.album.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * hey.io.heybackend.domain.album.dto.QAlbumResponse is a Querydsl Projection type for AlbumResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAlbumResponse extends ConstructorExpression<AlbumResponse> {

    private static final long serialVersionUID = -1109502856L;

    public QAlbumResponse(com.querydsl.core.types.Expression<? extends hey.io.heybackend.domain.album.domain.AlbumEntity> album) {
        super(AlbumResponse.class, new Class<?>[]{hey.io.heybackend.domain.album.domain.AlbumEntity.class}, album);
    }

}

