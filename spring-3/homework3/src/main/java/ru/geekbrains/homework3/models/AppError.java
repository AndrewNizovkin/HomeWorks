package ru.geekbrains.homework3.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class AppError {
    private int statusCode;
    private String message;

    public AppError(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
