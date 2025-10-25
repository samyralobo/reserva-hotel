package com.reserva.hotel.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private AuthorizationFilter authorizationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(csrf->csrf.disable())
                .sessionManagement(session-> session.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/hoteis").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,  "/hoteis").hasAnyRole("ADMIN", "FUNCIONARIO")
                        .requestMatchers(HttpMethod.PUT,  "/hoteis").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/hoteis").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/quartos").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/quartos").hasAnyRole("ADMIN", "FUNCIONARIO")
                        .requestMatchers(HttpMethod.PUT,  "/quartos").hasAnyRole("ADMIN", "FUNCIONARIO")
                        .requestMatchers(HttpMethod.DELETE,  "/quartos").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/reservas").hasAnyRole("ADMIN", "FUNCIONARIO")
                        .requestMatchers(HttpMethod.GET, "/reservas").hasAnyRole("ADMIN", "FUNCIONARIO")
                        .anyRequest().authenticated())
                .addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class).build();

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
