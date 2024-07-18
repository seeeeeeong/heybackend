package hey.io.heybackend.domain.oauth.service;

import hey.io.heybackend.common.exception.BusinessException;
import hey.io.heybackend.domain.user.domain.SocialCode;
import hey.io.heybackend.domain.user.domain.User;
import hey.io.heybackend.domain.user.service.ValidateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static hey.io.heybackend.common.exception.ErrorCode.INTERNAL_SERVER_ERROR;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OAuthService {

    private final GoogleOAuthService googleOAuthService;
    private final AppleOAuthService appleOAuthService;
    private final ValidateUserService validateUserService;

    @Transactional
    public void deleteAccount(Long userId) {
        User user = validateUserService.validateUserById(userId);
        if (user.getSocialCode() == SocialCode.GOOGLE) {
            googleOAuthService.deleteAccount(user);
        } else if (user.getSocialCode() == SocialCode.APPLE) {
            appleOAuthService.deleteAccount(user);
        } else {
            throw new BusinessException(INTERNAL_SERVER_ERROR);
        }
    }
}
