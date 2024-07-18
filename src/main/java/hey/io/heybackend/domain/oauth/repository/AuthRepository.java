package hey.io.heybackend.domain.oauth.repository;

import hey.io.heybackend.domain.oauth.domain.Auth;
import hey.io.heybackend.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Long> {

    Optional<Auth> findByUser(User user);
}
