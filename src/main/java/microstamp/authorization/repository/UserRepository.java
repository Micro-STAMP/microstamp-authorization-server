package microstamp.authorization.repository;

import microstamp.authorization.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByExternalId(UUID externalId);
}
