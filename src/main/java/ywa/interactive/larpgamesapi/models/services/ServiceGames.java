package ywa.interactive.larpgamesapi.models.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ywa.interactive.larpgamesapi.models.entities.Game;
import ywa.interactive.larpgamesapi.models.repositories.GamesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceGames {
    private final GamesRepository gamesRepository;

    //llistar tots els ítems
    public List<Game> listGames() {
        return gamesRepository.findAll();
    }

    public List<Game> listGamesByCountry(String country) {
        return gamesRepository.findByCountry(country);
    }

    public Game consultGame(Integer id) {
        return gamesRepository.findById(id).orElse(null);
    }

    public Game addGame(Game game) {
        return gamesRepository.save(game);
    }

    public Game modGame(Game game) {
        Game aux = null;
        if (gamesRepository.existsById(game.getId())) aux = gamesRepository.save(game);
        return aux;
    }

    public Game deleteGame(Game game) {
        Game res = gamesRepository.findById(game.getId()).orElse(null);
        if (res != null) gamesRepository.deleteById(game.getId());
        return res;
    }
}