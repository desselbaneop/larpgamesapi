package ywa.interactive.larpgamesapi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ywa.interactive.larpgamesapi.models.services.MyUserDetailsServise;
import ywa.interactive.larpgamesapi.security.JWT.JWTAuthorizationFilter;
import ywa.interactive.larpgamesapi.security.JWT.MyAuthEntryPoint;

@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigurationWebSecurity extends WebSecurityConfigurerAdapter {

    //    private final MyAuthEntryPoint myAuthEntryPoint;
    private final MyUserDetailsServise myUserDetailsServise;
    private final PasswordEncoder encrypted;
    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsServise).passwordEncoder(encrypted);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .passwordEncoder(encrypted)
                .withUser("User")
                .password(encrypted.encode("SecretPassword"))
                .roles("ADMIN");
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
//                .cors()
//                .and()
                .httpBasic()
                .and()
                //    .exceptionHandling().authenticationEntryPoint(elmeuEntryPoint)
                //    .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //per poder accedir al h2-console
                .authorizeRequests().antMatchers("/").permitAll().and()
                .authorizeRequests().antMatchers("/h2-console/**").permitAll()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()


                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/login").permitAll()
                // .antMatchers(HttpMethod.GET,"/login").permitAll()
                //.antMatchers(HttpMethod.GET, "/me/**").hasRole("ADMIN") //per fer proves del forbidden
                .antMatchers(HttpMethod.GET, "/login/**","/users/**", "/games/**", "/lores/**").hasRole("USER")
//                    .antMatchers(HttpMethod.POST, "/users/**", "/videojocs/**").hasRole("USER")
//                    .antMatchers(HttpMethod.PUT, "/games/**").hasRole("USER")
//                    .antMatchers(HttpMethod.DELETE, "/games/**").hasRole("ADMIN")
//                    .antMatchers(HttpMethod.POST, "/games/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated().and()
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
