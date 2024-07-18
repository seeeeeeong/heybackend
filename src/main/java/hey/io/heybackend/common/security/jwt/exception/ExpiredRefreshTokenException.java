package hey.io.heybackend.common.security.jwt.exception;


import hey.io.heybackend.common.exception.ErrorCode;

public class ExpiredRefreshTokenException extends TokenException{

    public ExpiredRefreshTokenException() {
        super(ErrorCode.EXPIRED_JWT_REFRESH_TOKEN);
    }

}
