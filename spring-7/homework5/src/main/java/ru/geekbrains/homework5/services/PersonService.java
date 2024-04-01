package ru.geekbrains.homework5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework5.model.Person;
import ru.geekbrains.homework5.repository.PersonRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    /**
     * Gets Person by login
     * @param login
     * @return
     */
    public Person findByLogin(String login) {
        return personRepository.findByLogin(login).orElseThrow(() ->
                new NoSuchElementException("Нет пользователя с логином: " + login));
    }

    @EventListener(ContextRefreshedEvent.class)
    private void createDemoPersons() {
        personRepository.save(new Person("admin", "admin", "admin"));
        personRepository.save(new Person("user", "user", "user"));
    }

}
