package hey.io.heybackend.domain.user.service;

import hey.io.heybackend.domain.oauth.domain.Auth;
import hey.io.heybackend.domain.oauth.dto.AppleIdToken;
import hey.io.heybackend.domain.oauth.repository.AuthRepository;
import hey.io.heybackend.domain.user.domain.SocialCode;
import hey.io.heybackend.domain.user.domain.User;
import hey.io.heybackend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final AuthRepository authRepository;

    @Transactional
    public User registerGoogleUser(String email, SocialCode socialCode, String refreshToken) {
        User user = userRepository.save(User.create(email, socialCode));
        Auth auth = Auth.builder()
                .user(user)
                .refreshToken(refreshToken)
                .build();
        authRepository.save(auth);
        return user;
    }

    @Transactional
    public User registerAppleUser(AppleIdToken appleIdToken, String refreshToken) {
        User user = userRepository.save(User.create(appleIdToken.getEmail(), SocialCode.APPLE));
        Auth auth = Auth.builder()
                .user(user)
                .idToken(appleIdToken.toString())
                .sub(appleIdToken.getSub())
                .refreshToken(refreshToken)
                .build();
        authRepository.save(auth);
        return user;
    }

    @Transactional
    public User registerKakaoUser(String email,SocialCode socialCode, String refreshToken) {
        User user = userRepository.save(User.create(email, socialCode));
        Auth auth = Auth.builder()
                .user(user)
                .refreshToken(refreshToken)
                .build();
        authRepository.save(auth);
        return user;
    }
}
