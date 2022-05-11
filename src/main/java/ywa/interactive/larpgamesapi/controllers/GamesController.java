package ywa.interactive.larpgamesapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ywa.interactive.larpgamesapi.models.entities.Game;
import ywa.interactive.larpgamesapi.models.services.ServiceGames;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GamesController {
    private final ServiceGames serviceGames;

    /*@GetMapping("/games")
    public List<Game> listGames(){
        return serviceGames.listGames();
    }

    @GetMapping("/games/{id}")
    public Game consultGame(@PathVariable String id){
        return serviceGames.consultGame(id);
    }

    @GetMapping("/games/country/{country}")
    public List<Game> listGamesByCountry(@PathVariable String country){
        return serviceGames.listGamesByCountry(country);
    }

    @GetMapping("/games/count/{country}")
    public long countGamesByCountry(@PathVariable String country){
        return serviceGames.countByCountry(country);
    }

    @PostMapping("/users")
    public Game crearUsuari(@RequestBody Game game){
        return serviceGames.addGame(game);
    }

    @DeleteMapping("/users/{id}")
    public Game eliminarUsuari(@PathVariable String id){
        return serviceGames.deleteGame(id);
    }

    @PutMapping("/users")
    public Game modificarUsuari(@RequestBody Game game){
        return serviceGames.modGame(game);
    }*/
}
