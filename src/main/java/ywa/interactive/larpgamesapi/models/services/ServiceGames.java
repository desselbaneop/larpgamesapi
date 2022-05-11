package ywa.interactive.larpgamesapi.models.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ywa.interactive.larpgamesapi.models.entities.Game;
import ywa.interactive.larpgamesapi.models.repositories.RepositoryGames;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceGames {
    private final RepositoryGames repositoryGames;

    //llistar tots els ítems
    public List<Game> listGames() {
        return repositoryGames.findAll();
    }


    public List<Game> listGamesByCountry(String country) {
        return repositoryGames.findByCountry(country);
    }

    public long countByCountry(String country) {
        return repositoryGames.countByCountry(country);
    }

    public Game consultGame(Integer id) {
        return repositoryGames.findById(id).orElse(null);
    }

    public Game addGame(Game game) {
        return repositoryGames.save(game);
    }

    public Game modGame(Game game) {
        Game aux = null;
        if (repositoryGames.existsById(game.getId())) aux = repositoryGames.save(game);
        return aux;
    }

    public Game deleteGame(Integer id) {
        Game res = repositoryGames.findById(id).orElse(null);
        if (res != null) repositoryGames.deleteById(id);
        return res;
    }
}