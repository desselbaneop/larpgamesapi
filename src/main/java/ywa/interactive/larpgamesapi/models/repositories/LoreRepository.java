package ywa.interactive.larpgamesapi.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ywa.interactive.larpgamesapi.models.entities.Lore;

import java.util.List;

public interface LoreRepository extends JpaRepository<Lore, Integer>{
    List<Lore> findByRating(double rating);

    List<Lore> findByAgeCategory(int ageCategory);
}
