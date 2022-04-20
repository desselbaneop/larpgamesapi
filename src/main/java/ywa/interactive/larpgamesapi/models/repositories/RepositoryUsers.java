package ywa.interactive.larpgamesapi.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ywa.interactive.larpgamesapi.models.entities.User;

import java.util.List;

public interface RepositoryUsers extends JpaRepository<User, String> {
    List<User> findByRole(String role);
    long countByRole(String role);
}
