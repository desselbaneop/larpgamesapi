package ywa.interactive.larpgamesapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ywa.interactive.larpgamesapi.models.entities.User;
import ywa.interactive.larpgamesapi.models.services.ServiceUsers;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsersController {
    private final ServiceUsers serviceUsers;

    @CrossOrigin(origins="http://localhost:9001")
    @GetMapping("/users")
    public List<User> listUsers(){
        return serviceUsers.listUsers();
    }

    @GetMapping("/users/{id}")
    public User consultUser(@PathVariable String id){
        return serviceUsers.consultUser(id);
    }

    @GetMapping("/users/role/{role}")
    public List<User> listUsersByRole(@PathVariable String role){
        return serviceUsers.listUsersByRole(role);
    }

    @GetMapping("/users/count/{role}")
    public long countByRole(@PathVariable String role){
        return serviceUsers.countByRole(role);
    }

    @PostMapping("/users")
    public User crearUsuari(@RequestBody User user){
        return serviceUsers.addUser(user);
    }

    @DeleteMapping("/users/{id}")
    public User eliminarUsuari(@PathVariable String id){
        return serviceUsers.deleteUser(id);
    }

    @PutMapping("/users")
    public User modificarUsuari(@RequestBody User user){
        return serviceUsers.modUser(user);
    }
}
