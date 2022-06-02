package ywa.interactive.larpgamesapi.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ywa.interactive.larpgamesapi.models.entities.Game;

import java.util.List;

public interface GamesRepository extends JpaRepository<Game, Integer> {
    List<Game> findByCountry(String country);

    long countByCountry(String country);
}
