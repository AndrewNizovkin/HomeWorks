package ru.geekbrains.homework5.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.geekbrains.homework5.model.Person;
import ru.geekbrains.homework5.services.PersonService;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final PersonService personService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Person person = personService.findByLogin(username);
            log.info("Найден пользователь" + person);
            return new User(person.getLogin(), person.getPassword(), List.of(
                    new SimpleGrantedAuthority(person.getRole())
            ));
        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
