package hey.io.heybackend.common.security.jwt;

import hey.io.heybackend.domain.user.domain.UserRole;
import lombok.Builder;
import lombok.Getter;

@Getter
public class JwtTokenInfo {

    private final Long userId;
    private final UserRole userRole;

    @Builder
    public JwtTokenInfo(Long userId, UserRole userRole) {
        this.userId = userId;
        this.userRole = userRole;
    }
}
