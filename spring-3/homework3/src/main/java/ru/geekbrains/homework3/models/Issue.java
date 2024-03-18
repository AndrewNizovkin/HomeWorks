package ru.geekbrains.homework3.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Issue {
    private static long counter;

    private final long id;
    private final long idReader;
    private final long idBook;
    private final LocalDateTime time;

    public Issue(long idReader, long idBook) {
        this.idReader = idReader;
        this.idBook = idBook;
        id = ++counter;
        time = LocalDateTime.now();
    }
}
