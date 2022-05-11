package ywa.interactive.larpgamesapi.models.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashSet;

@Entity
@Data
@RequiredArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private String id; //identificador autonumèric

    @Column(unique = true)
    private String username; //no es repeteix username

    private String password;
    private String avatar;

    private String role = "USER"; //per defecte

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        //l'altre rol seria "ROLE_ADMIN", per exemple
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
