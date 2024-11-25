package com.barbershop.barbershop_backend.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Desabilita CSRF (opcional, dependendo do uso)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/clients", "/auth/login").permitAll() // Permite acesso público ao cadastro e login
                        .anyRequest().authenticated() // Exige autenticação para outros endpoints

                );
        return http.build();
    }
}
