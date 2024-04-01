package ru.geekbrains.homework5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.homework5.model.Person;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByLogin(String login);
}
