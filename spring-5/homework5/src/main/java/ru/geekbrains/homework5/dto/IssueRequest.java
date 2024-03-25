package ru.geekbrains.homework5.dto;

import lombok.Data;

@Data
public class IssueRequest {
    private long readerId;
    private long bookId;
}
