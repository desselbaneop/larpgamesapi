package ywa.interactive.larpgamesapi.models.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ywa.interactive.larpgamesapi.models.entities.User;
import ywa.interactive.larpgamesapi.models.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;

    private final PasswordEncoder xifrat;

    public User checkUserByUsername(String username) {
        return usersRepository.findByUsername(username).orElse(null);
    }

    public User createNewUser(User newUser) {
        newUser.setPassword(xifrat.encode(newUser.getPassword()));
        usersRepository.save(newUser);
        return newUser;
    }

    public User checkUserById(Long id){
        return usersRepository.findById(id).orElse(null);
    }

    public List<User> listUsers(){
        return usersRepository.findAll();
    }
}
