package ru.geekbrains.homework3.models;

import lombok.Data;

@Data
public class Reader {
    private static long counter;

    private final long id;
    private final String name;

    public Reader(String name) {
        this.name = name;
        id = ++counter;

    }
}
