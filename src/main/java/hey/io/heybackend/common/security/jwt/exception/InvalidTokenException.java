package hey.io.heybackend.common.security.jwt.exception;

import hey.io.heybackend.common.exception.ErrorCode;

public class InvalidTokenException extends TokenException{

    public InvalidTokenException(Throwable e) {
        super(ErrorCode.INVALID_TOKEN, e);
    }

    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }

}
