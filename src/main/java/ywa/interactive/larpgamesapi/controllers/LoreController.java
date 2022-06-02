package ywa.interactive.larpgamesapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ywa.interactive.larpgamesapi.models.entities.Lore;
import ywa.interactive.larpgamesapi.models.services.LoreService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoreController {
    private final LoreService loreService;

    @GetMapping("/lores")
    public ResponseEntity<?> getLoreList(){
        List<Lore> res = loreService.listLores();
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @GetMapping("/lores/{id}")
    public ResponseEntity<?> consultLore(@PathVariable Integer id) {
        Lore res = loreService.consultLore(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @PostMapping("/lores")
    public ResponseEntity<?> createLore(@RequestBody Lore lore) {
        Lore res = loreService.addLore(lore);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/lores")
    public ResponseEntity<?> updateLore(@RequestBody Lore lore){
        Lore res = loreService.modLore(lore);
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/lores")
    public ResponseEntity<?> deleteLore(@RequestBody Lore lore){
        Lore res = loreService.deleteLore(lore);
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }
}
