package hey.io.heybackend.common.security.jwt.exception;

import hey.io.heybackend.common.exception.ErrorCode;

public class ExpiredAccessTokenException extends TokenException{
    public ExpiredAccessTokenException() {
        super(ErrorCode.EXPIRED_JWT_ACCESS_TOKEN);
    }
}
