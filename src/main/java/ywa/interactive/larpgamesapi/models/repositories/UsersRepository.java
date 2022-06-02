package ywa.interactive.larpgamesapi.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ywa.interactive.larpgamesapi.models.entities.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
