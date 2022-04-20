package ywa.interactive.larpgamesapi.models.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ywa.interactive.larpgamesapi.models.entities.User;
import ywa.interactive.larpgamesapi.models.repositories.RepositoryUsers;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceUsers {
    private final RepositoryUsers repositoryUsers;

    //llistar tots els ítems
    public List<User> listUsers() {
        return repositoryUsers.findAll();
    }


    public List<User> listUsersByRole(String role) {
        return repositoryUsers.findByRole(role);
    }

    public long countByRole(String role) {
        return repositoryUsers.countByRole(role);
    }

    public User consultUser(String id) {
        return repositoryUsers.findById(id).orElse(null);
    }

    public User addUser(User user) {
        return repositoryUsers.save(user);
    }

    public User modUser(User user) {
        User aux = null;
        if (repositoryUsers.existsById(user.getId())) aux = repositoryUsers.save(user);
        return aux;
    }

    public User deleteUser(String id) {
        User res = repositoryUsers.findById(id).orElse(null);
        if (res != null) repositoryUsers.deleteById(id);
        return res;
    }
}