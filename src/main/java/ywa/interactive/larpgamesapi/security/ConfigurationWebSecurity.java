package ywa.interactive.larpgamesapi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ywa.interactive.larpgamesapi.models.services.MyUserDetailsServise;

@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigurationWebSecurity extends WebSecurityConfigurerAdapter {

    private final MyAuthEntryPoint myAuthEntryPoint;
    private final MyUserDetailsServise myUserDetailsServise;
    private final PasswordEncoder encrypted;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsServise).passwordEncoder(encrypted);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.cors() //amb aquesta línia evitem la configuració custom del cors en un fitxer a part
            .and()
            .httpBasic()
            .authenticationEntryPoint(myAuthEntryPoint)
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/me/**").hasRole("ADMIN") //per fer proves del forbidden
            .antMatchers(HttpMethod.GET, "/users/**", "/games/**", "/lores/**").hasRole("USER")
            .antMatchers(HttpMethod.POST, "/users/**", "/games/**", "/lores/**").hasRole("USER")
            .antMatchers(HttpMethod.PUT, "/games/**").hasRole("USER")
            .antMatchers(HttpMethod.DELETE, "/games/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST, "/games/**", "/lores/**").hasAnyRole("USER", "ADMIN")
            .antMatchers(HttpMethod.PUT, "/lores/**").hasRole("USER")
            .antMatchers(HttpMethod.DELETE, "/lores/**").hasRole("ADMIN")
            .anyRequest().authenticated();
            // .and()
            // .csrf().disable();
            }
}
