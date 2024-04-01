package ru.geekbrains.homework5.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .authorizeHttpRequests(registry -> registry
                        .requestMatchers("ui/books/**").hasAnyAuthority("user", "admin")
                        .requestMatchers("ui/readers/**").hasAuthority("admin")
                        .requestMatchers("ui/issues/**", "book/**").permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .build();

    }
}
