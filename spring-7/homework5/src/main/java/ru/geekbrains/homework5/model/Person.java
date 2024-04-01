package ru.geekbrains.homework5.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "persons")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    public Person() {
    }

    public Person(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
