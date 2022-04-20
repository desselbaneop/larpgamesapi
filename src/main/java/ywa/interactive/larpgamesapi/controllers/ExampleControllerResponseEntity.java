package ywa.interactive.larpgamesapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ywa.interactive.larpgamesapi.models.entities.User;
import ywa.interactive.larpgamesapi.models.services.ServiceUsers;

@RestController
@RequiredArgsConstructor
public class ExampleControllerResponseEntity {
    private final ServiceUsers serviceUsers;

    @GetMapping("/user/{id}")
    public ResponseEntity<?> consultUser(@PathVariable String id) {
        User res = serviceUsers.consultUser(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @PostMapping("/user")
    public ResponseEntity<?> crearUsusari(@RequestBody User user) {
        User res = serviceUsers.addUser(user);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
