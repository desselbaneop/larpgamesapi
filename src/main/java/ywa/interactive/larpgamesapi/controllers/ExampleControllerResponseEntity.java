package ywa.interactive.larpgamesapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ywa.interactive.larpgamesapi.models.entities.Game;
import ywa.interactive.larpgamesapi.models.services.ServiceGames;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExampleControllerResponseEntity {
    private final ServiceGames serviceGames;

    @GetMapping("/games")
    public ResponseEntity<?> getGames(){
        List<Game> res = serviceGames.listGames();
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<?> consultGame(@PathVariable Integer id) {
        Game res = serviceGames.consultGame(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @GetMapping("/games/country/{country}")
    public ResponseEntity<?> getGamesByCountry(@PathVariable String country){
        List<Game> gamesByCounty = serviceGames.listGamesByCountry(country);
        if (gamesByCounty == null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(gamesByCounty);
        }
    }

    @PostMapping("/game")
    public ResponseEntity<?> createGame(@RequestBody Game game) {
        System.out.println(game);
        Game res = serviceGames.addGame(game);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


}
