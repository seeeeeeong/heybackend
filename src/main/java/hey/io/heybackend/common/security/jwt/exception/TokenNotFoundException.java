package hey.io.heybackend.common.security.jwt.exception;

import hey.io.heybackend.common.exception.ErrorCode;

public class TokenNotFoundException extends TokenException{

    public TokenNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    public TokenNotFoundException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

}
