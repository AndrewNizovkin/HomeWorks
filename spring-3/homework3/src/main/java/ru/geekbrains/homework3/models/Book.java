package ru.geekbrains.homework3.models;

import lombok.Data;

@Data
public class Book {
    private  static long counter;
    private final long id;
    private final String name;


    public Book(String name) {
        this.name = name;
        id = ++counter;
    }
}
