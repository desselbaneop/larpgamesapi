package ywa.interactive.larpgamesapi.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ywa.interactive.larpgamesapi.models.entities.User;
import ywa.interactive.larpgamesapi.models.entities.UserConsultDTO;
import ywa.interactive.larpgamesapi.models.services.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControllerRegisterLoginUsers {
    private final UserService userService;


    @GetMapping("/me")
    public UserConsultDTO checkForMe(@AuthenticationPrincipal User user) {
        return new UserConsultDTO(user.getUsername(), user.getAvatar(), user.getRol());
    }

    /*
    {
    "username":"Montse",
    "password":"1234",
    "avatar":"http://imatge.com"
    }
    Afegeix id automàticament
     */

    @PostMapping("/users")
    public ResponseEntity<?> newUser(@RequestBody User newUser) {
        try {
            User res = userService.createNewUser(newUser);
            UserConsultDTO user = new UserConsultDTO(res.getUsername(), res.getAvatar(), res.getRol());
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException ex) {
            //per si intentem afegir 2 usuaris amb el mateix username, saltarà excepció
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> listUsersDTO() {
        List<User> res = userService.listUsers();
        List<UserConsultDTO> aux = new ArrayList();
        for (User user : res) {
            aux.add(new UserConsultDTO(user.getUsername(), user.getAvatar(), user.getRol()));
        }
        if (res.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else return ResponseEntity.ok(aux);
    }
}
