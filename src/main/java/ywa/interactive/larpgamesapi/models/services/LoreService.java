package ywa.interactive.larpgamesapi.models.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ywa.interactive.larpgamesapi.models.entities.Lore;
import ywa.interactive.larpgamesapi.models.repositories.LoreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoreService {
    private final LoreRepository loreRepository;

    //llistar tots els ítems
    public List<Lore> listLores() {
        return loreRepository.findAll();
    }

    public List<Lore> listLoresByRating(double raiting) {
        return loreRepository.findByRating(raiting);
    }

    public List<Lore> listLoresByAgeCategory(int age) {
        return loreRepository.findByAgeCategory(age);
    }

    public Lore consultLore(Integer id) {
        return loreRepository.findById(id).orElse(null);
    }

    public Lore addLore(Lore lore) {
        return loreRepository.save(lore);
    }

    public Lore modLore(Lore lore) {
        Lore aux = null;
        if (loreRepository.existsById(lore.getId())) aux = loreRepository.save(lore);
        return aux;
    }

    public Lore deleteLore(Lore lore) {
        Lore res = loreRepository.findById(lore.getId()).orElse(null);
        if (res != null) loreRepository.deleteById(lore.getId());
        return res;
    }
}
